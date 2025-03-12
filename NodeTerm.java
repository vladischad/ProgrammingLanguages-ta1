/**
 * Represents a term in the parse tree.
 * A term consists of factors combined with multiplication or division operators.
 */
public class NodeTerm extends Node {

	private NodeFact fact;
	private NodeMulop mulop;
	private NodeTerm term;

	/**
     * Constructs a NodeTerm with a factor, an operator, and another term.
     * @param fact The first factor of the term.
     * @param mulop The multiplication or division operator.
     * @param term The remaining part of the term.
     */
    public NodeTerm(NodeFact fact, NodeMulop mulop, NodeTerm term) {
		this.fact=fact;
		this.mulop=mulop;
		this.term=term;
	}

	/**
     * Appends another term to this one, maintaining the operator hierarchy.
     * @param term The term to append.
     */
    public void append(NodeTerm term) {
		if (this.term==null) {
			this.mulop=term.mulop;
			this.term=term;
			term.mulop=null;
		} else
			this.term.append(term);
	}

	/**
     * Evaluates the term by recursively applying operators to factors.
     * @param env The environment in which variables are stored.
     * @return The evaluated result.
     * @throws EvalException If an error occurs during evaluation.
     */
    public int eval(Environment env) throws EvalException {
		return term==null
			? fact.eval(env)
			: mulop.op(term.eval(env),fact.eval(env));
	}

	/**
     * Generates C code for the term.
     * @return A string containing the C code representation of the term.
     */
    public String code() {
		return (term==null ? "" : term.code()+mulop.code())+fact.code();
	}

}
