// This is the main class/method for the interpreter/compiler.
// Each command-line argument is a complete program,
// which is scanned, parsed, and evaluated.
// All evaluations share the same environment,
// so they can share variables.

/**
 * Main class for the interpreter/compiler.
 * It parses, evaluates, and optionally generates C code from the input source programs.
 */
public class Main {

	/**
     * Entry point of the program.
     * Parses and evaluates each command-line argument as a separate source program.
     * Accumulates the generated code and passes it to the Code generator.
     *
     * @param args Command-line arguments representing source programs.
     */
    public static void main(String[] args) {
		Parser parser=new Parser();
		Environment env=new Environment();
		String code="";
		for (String prog: args)
			try {
				Node node=parser.parse(prog);
				node.eval(env);
				code+=node.code();
			} catch (Exception e) {
				System.err.println(e);
			}
		new Code(code,env);
	}

}
