# Educational Truffle Debugger Instrument 

This is a project that aims to be a playground to study the behaviour of the [Truffle Debugger API](https://www.graalvm.org/truffle/javadoc/com/oracle/truffle/api/debug/package-summary.html).

**Note that this is not a functioning debugger.** Since this project only serves as a playground to study the API's behaviour, things like requesting the line number for breakpoints, or printing the variables in the current stack frame were not implemented. The observation of the behaviours are mostly done in debug mode (e.g. IntelliJ's debug mode) using JUnit test instances.

I'm so lazy that even setting breakpoint line is done manually in the [DebuggerInstrument.java](https://github.com/adilrifqi/Educational-Truffle-Debugger-Instrument/blob/main/src/main/java/debugger/DebuggerInstrument.java) file. XD