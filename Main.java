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
     * Parses and evaluates all command-line arguments as a single source program.
     * Accumulates the generated code and passes it to the Code generator.
     *
     * @param args Command-line arguments representing source programs.
     */
    public static void main(String[] args) {
        Parser parser = new Parser();
        Environment env = new Environment();
        StringBuilder code = new StringBuilder();
        
        // Concatenate all command-line arguments into a single program string
        StringBuilder program = new StringBuilder();
        for (String arg : args) {
            program.append(arg).append(" ");
        }
        
        try {
            // Parse and evaluate the entire concatenated program
            Node node = parser.parse(program.toString().trim());
            node.eval(env);
            code.append(node.code());
        } catch (Exception e) {
            System.err.println(e);
        }
        
        // Generate code output
        new Code(code.toString(), env);
    }
}
