// This class, and its subclasses,
// collectively model parse-tree nodes.
// Each kind of node can be eval()-uated,
// and/or code()-generated.

/**
 * Abstract class representing a node in the parse tree.
 * Each subclass of Node corresponds to a different construct in the language.
 */
public abstract class Node {

	protected int pos=0;

	/**
     * Evaluates the node in the given environment.
     * Subclasses should override this method to provide specific evaluation logic.
     *
     * @param env The environment in which the node is evaluated.
     * @return The result of evaluation.
     * @throws EvalException If the node cannot be evaluated.
     */
    public int eval(Environment env) throws EvalException {
		throw new EvalException(pos,"cannot eval() node!");
	}

	/**
     * Generates C code representation of this node.
     * Subclasses should override this method if code generation is needed.
     *
     * @return A string containing the C code representation.
     */
    public String code() { return ""; }

}
