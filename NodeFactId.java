/**
 * Represents a factor that is an identifier (a variable reference).
 * This node retrieves the value of a variable from the environment.
 */
public class NodeFactId extends NodeFact {

	private String id;

	/**
     * Constructs a NodeFactId with a variable identifier.
     * @param pos The position of the variable in the source code.
     * @param id The variable name.
     */
    public NodeFactId(int pos, String id) {
		this.pos=pos;
		this.id=id;
	}

	/**
     * Evaluates the identifier by retrieving its value from the environment.
     * @param env The environment where variables are stored.
     * @return The value of the variable.
     * @throws EvalException If the variable is undefined.
     */
    public int eval(Environment env) throws EvalException {
		return env.get(pos,id);
	}

	/**
     * Generates C code for the variable reference.
     * @return A string containing the variable name as C code.
     */
    public String code() { return id; }

}
