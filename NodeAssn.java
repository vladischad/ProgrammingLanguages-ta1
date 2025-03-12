/**
 * Represents an assignment operation in the parse tree.
 * This node assigns the result of an expression to a variable.
 */
public class NodeAssn extends Node {

	private String id;
	private NodeExpr expr;

	/**
     * Constructs a NodeAssn with a variable name and an expression.
     * @param id The variable name.
     * @param expr The expression to be evaluated and assigned.
     */
    public NodeAssn(String id, NodeExpr expr) {
		this.id = id;
		this.expr = expr;
	}

	/**
     * Evaluates the expression and assigns its result to the variable in the environment.
     * @param env The environment where variables are stored.
     * @return The assigned value.
     * @throws EvalException If an evaluation error occurs.
     */
    public int eval(Environment env) throws EvalException {
		return env.put(id, new NodeWr(expr).eval(env));
	}

	/**
     * Generates C code for the assignment operation.
     * @return A string containing the C assignment statement.
     */
    public String code() {
		return id + "=" + expr.code() + ";" + new NodeWr(expr).code();
	}

}
