/**
 * Represents a factor that consists of an expression enclosed in parentheses.
 * This node allows expressions to be treated as factors in mathematical operations.
 */
public class NodeFactExpr extends NodeFact {

	private NodeExpr expr;

	/**
     * Constructs a NodeFactExpr with an expression.
     * @param expr The expression inside the parentheses.
     */
    public NodeFactExpr(NodeExpr expr) {
		this.expr=expr;
	}

	/**
     * Evaluates the expression within this factor.
     * @param env The environment where variables are stored.
     * @return The evaluated result of the expression.
     * @throws EvalException If an evaluation error occurs.
     */
    public int eval(Environment env) throws EvalException {
		return expr.eval(env);
	}

	/**
     * Generates C code for the expression within parentheses.
     * @return A string containing the C code representation.
     */
    public String code() { return "("+expr.code()+")"; }

}
