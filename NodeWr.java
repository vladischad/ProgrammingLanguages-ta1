/**
 * Represents a write operation in the parse tree.
 * This node evaluates an expression and prints the result.
 */
public class NodeWr extends Node {

	private NodeExpr expr;

	/**
     * Constructs a NodeWr with an expression to be printed.
     * @param expr The expression whose result is printed.
     */
    public NodeWr(NodeExpr expr) {
		this.expr=expr;
	}

	/**
     * Evaluates the expression and prints its value.
     * If the value is a whole number, it prints it as an integer; otherwise, as a double.
     * @param env The environment in which the expression is evaluated.
     * @return The evaluated result of the expression.
     * @throws EvalException If an evaluation error occurs.
     */
    public int eval(Environment env) throws EvalException {
		int d=expr.eval(env);
		int i=(int) d;
		if (i==d)
			System.out.println(i);
		else
			System.out.println(d);
		return d;
	}

	/**
     * Generates C code for the write operation using printf.
     * @return A string containing the C printf statement.
     */
    public String code() {
		return "printf(\"%g\\n\","
			+"(double)("
			+expr.code()
			+"));";
	}

}
