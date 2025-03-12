/**
 * Represents a numeric literal in the parse tree.
 * This node holds a number as a string and converts it during evaluation.
 */
public class NodeFactNum extends NodeFact {

	private String num;

	/**
     * Constructs a NodeFactNum with a numeric value.
     * @param num The numeric value as a string.
     */
    public NodeFactNum(String num) {
		this.num=num;
	}

	/**
     * Evaluates the numeric literal by converting it to an integer.
     * @param env The environment (not used for literals).
     * @return The integer value of the number.
     * @throws EvalException If the number format is invalid.
     */
    public int eval(Environment env) throws EvalException {
		return Integer.parseInt(num);
	}

	/**
     * Generates C code for the numeric literal.
     * @return A string containing the numeric value.
     */
    public String code() { return num; }

}
