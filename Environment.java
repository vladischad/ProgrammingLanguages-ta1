// This class provides a stubbed-out environment.
// You are expected to implement the methods.
// Accessing an undefined variable should throw an exception.

// Hint!
// Use the Java API to implement your Environment.
// Browse:
//   https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html
// Read about Collections.
// Focus on the Map interface and HashMap implementation.
// Also:
//   https://www.tutorialspoint.com/java/java_map_interface.htm
//   http://www.javatpoint.com/java-map
// and elsewhere.

/**
 * The Environment class manages variable storage and retrieval for the interpreter.
 * It also generates C code declarations for the variables used in the program.
 */
public class Environment {

	private String[] map = { "x" };

	/**
     * Stores a variable and its value in the environment.
     * Currently, this is a stub implementation that simply returns the given value.
     * @param var The variable name.
     * @param val The value to store.
     * @return The stored value.
     */
	public int put(String var, int val) {
		return val;
	}

	/**
     * Retrieves the value of a given variable from the environment.
     * Currently, this is a stub that always returns 0.
     * @param pos The position in the source code where the variable is accessed.
     * @param var The variable name.
     * @return The value of the variable.
     * @throws EvalException If the variable is undefined.
     */
    public int get(int pos, String var) throws EvalException {
		return 0;
	}

	/**
     * Generates C code for variable declarations based on the stored environment.
     * @return A string containing C variable declarations.
     */
    public String toC() {
		String s = "";
		String sep = " ";
		for (String v : map) {
			s += sep + v;
			sep = ",";
		}
		return s == "" ? "" : "int" + s + ";\nx=0;x=x;\n";
	}

}
