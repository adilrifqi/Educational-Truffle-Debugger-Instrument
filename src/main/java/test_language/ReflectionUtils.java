package test_language;

import java.lang.reflect.*;

public class ReflectionUtils {

    public static Class<?> loadRelative(Class<?> testClass, String className) {
        String pack = testClass.getPackage().getName();
        try {
            pack = pack.replace("test.", "");
            return testClass.getClassLoader().loadClass(pack + "." + className);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static <T> T newInstance(Class<T> clazz, Object... args) {
        return newInstance(clazz, inferTypes(args), args);
    }

    public static Object getField(Object value, String name) {
        try {
            Field f = value.getClass().getDeclaredField(name);
            setAccessible(f, true);
            return f.get(value);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static Object getStaticField(Class<?> clazz, String name) {
        try {
            Field f = clazz.getDeclaredField(name);
            setAccessible(f, true);
            return f.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static <T> T newInstance(Class<T> clazz, Class<?>[] argTypes, Object... args) {
        try {
            Constructor<T> m = clazz.getDeclaredConstructor(argTypes);
            setAccessible(m, true);
            return m.newInstance(args);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static Object invokeStatic(Class<?> object, String name, Object... args) {
        return invokeStatic(object, name, inferTypes(args), args);
    }

    public static Object invokeStatic(Class<?> clazz, String name, Class<?>[] argTypes, Object... args) {
        try {
            Method m = clazz.getDeclaredMethod(name, argTypes);
            setAccessible(m, true);
            return m.invoke(null, args);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Calls {@link AccessibleObject#setAccessible(boolean)} on {@code field} with the value
     * {@code flag}.
     */
    public static void setAccessible(Field field, boolean flag) {
        if (!Java8OrEarlier) {
            openForReflectionTo(field.getDeclaringClass(), ReflectionUtils.class);
        }
        field.setAccessible(flag);
    }

    public static final boolean Java8OrEarlier = System.getProperty("java.specification.version").compareTo("1.9") < 0;

    /**
     * Calls {@link AccessibleObject#setAccessible(boolean)} on {@code executable} with the value
     * {@code flag}.
     */
    public static void setAccessible(Executable executable, boolean flag) {
        if (!Java8OrEarlier) {
            openForReflectionTo(executable.getDeclaringClass(), ReflectionUtils.class);
        }
        executable.setAccessible(flag);
    }

    /**
     * Opens {@code declaringClass}'s package to allow a method declared in {@code accessor} to call
     * {@link AccessibleObject#setAccessible(boolean)} on an {@link AccessibleObject} representing a
     * field or method declared by {@code declaringClass}.
     */
    private static void openForReflectionTo(Class<?> declaringClass, Class<?> accessor) {
        try {
            Method getModule = Class.class.getMethod("getModule");
            Class<?> moduleClass = getModule.getReturnType();
            Class<?> modulesClass = Class.forName("jdk.internal.module.Modules");
            Method addOpens = maybeGetAddOpensMethod(moduleClass, modulesClass);
            if (addOpens != null) {
                Object moduleToOpen = getModule.invoke(declaringClass);
                Object accessorModule = getModule.invoke(accessor);
                if (moduleToOpen != accessorModule) {
                    addOpens.invoke(null, moduleToOpen, declaringClass.getPackage().getName(), accessorModule);
                }
            }
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    private static Method maybeGetAddOpensMethod(Class<?> moduleClass, Class<?> modulesClass) {
        try {
            return modulesClass.getDeclaredMethod("addOpens", moduleClass, String.class, moduleClass);
        } catch (NoSuchMethodException e) {
            // This method was introduced by JDK-8169069
            return null;
        }
    }

    public static Object invoke(Object object, String name, Class<?>[] argTypes, Object... args) {
        try {
            return requireDeclaredMethod(object.getClass(), name, argTypes).invoke(object, args);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static Method requireDeclaredMethod(Class<?> clazz, String name, Class<?>[] argTypes) {
        try {
            Method found = null;
            if (argTypes == null) {
                // search just by name
                for (Method search : clazz.getDeclaredMethods()) {
                    if (search.getName().equals(name)) {
                        if (found != null) {
                            throw new AssertionError("Ambiguous method name " + search + " " + found + ". Use argTypes to disamgbiguate.");
                        }
                        found = search;
                    }
                }
                if (found == null) {
                    throw new NoSuchMethodException(name);
                }
            } else {
                found = clazz.getDeclaredMethod(name, argTypes);
            }
            setAccessible(found, true);
            return found;
        } catch (Exception e) {
            throw new AssertionError(e);
        }

    }

    public static Object invoke(Object object, String name, Object... args) {
        return invoke(object, name, inferTypes(args), args);
    }

    private static Class<?>[] inferTypes(Object... args) {
        Class<?>[] argTypes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                argTypes[i] = Object.class;
            } else {
                argTypes[i] = args[i].getClass();
            }
        }
        return argTypes;
    }

}