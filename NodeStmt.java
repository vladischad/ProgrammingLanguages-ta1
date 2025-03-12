/**
 * Represents a statement in the parse tree.
 * A statement consists of an assignment operation.
 */
public class NodeStmt extends Node {

	private NodeAssn assn;

	/**
     * Constructs a NodeStmt with an assignment operation.
     * @param assn The assignment node representing the statement.
     */
    public NodeStmt(NodeAssn assn) {
		this.assn=assn;
	}

	/**
     * Evaluates the statement by executing the assignment.
     * @param env The environment where variables are stored.
     * @return The evaluated result of the assignment.
     * @throws EvalException If an evaluation error occurs.
     */
    public int eval(Environment env) throws EvalException {
		return assn.eval(env);
	}

	/**
     * Generates C code for the statement.
     * @return A string containing the C code representation of the statement.
     */
    public String code() { return assn.code(); }

}
