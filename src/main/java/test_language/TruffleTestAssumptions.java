package test_language;

import org.junit.Assume;

public class TruffleTestAssumptions {
    private static final boolean spawnIsolate = "true".equals(System.getProperty("polyglot.engine.SpawnIsolate"));

    public static void assumeWeakEncapsulation() {
        Assume.assumeFalse(spawnIsolate);
    }

    public static boolean isWeakEncapsulation() {
        return !spawnIsolate;
    }
}