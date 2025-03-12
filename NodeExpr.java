/**
 * Represents an expression in the parse tree.
 * An expression consists of terms combined with addition or subtraction operators.
 */
public class NodeExpr extends Node {

	private NodeTerm term;
	private NodeAddop addop;
	private NodeExpr expr;

	/**
     * Constructs a NodeExpr with a term, an operator, and another expression.
     * @param term The first term of the expression.
     * @param addop The addition or subtraction operator.
     * @param expr The remaining part of the expression.
     */
    public NodeExpr(NodeTerm term, NodeAddop addop, NodeExpr expr) {
		this.term=term;
		this.addop=addop;
		this.expr=expr;
	}

	/**
     * Appends another expression to this one, maintaining the operator hierarchy.
     * @param expr The expression to append.
     */
    public void append(NodeExpr expr) {
		if (this.expr==null) {
			this.addop=expr.addop;
			this.expr=expr;
			expr.addop=null;
		} else
			this.expr.append(expr);
	}

	/**
     * Evaluates the expression by recursively applying operators to terms.
     * @param env The environment in which variables are stored.
     * @return The evaluated result.
     * @throws EvalException If an error occurs during evaluation.
     */
    public int eval(Environment env) throws EvalException {
		return expr==null
			? term.eval(env)
			: addop.op(expr.eval(env),term.eval(env));
	}

	/**
     * Generates C code for the expression.
     * @return A string containing the C code representation of the expression.
     */
    public String code() {
		return (expr==null ? "" : expr.code()+addop.code())+term.code();
	}

}
