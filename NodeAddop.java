/**
 * Represents an addition or subtraction operation in the parse tree.
 * This node handles binary addition and subtraction.
 */
public class NodeAddop extends Node {

	private String addop;

	/**
     * Constructs a NodeAddop with a specific position and operator.
     * @param pos The position of the operator in the source code.
     * @param addop The addition or subtraction operator as a string.
     */
	public NodeAddop(int pos, String addop) {
		this.pos=pos;
		this.addop=addop;
	}

	/**
     * Performs the operation on two operands.
     * @param o1 The first operand.
     * @param o2 The second operand.
     * @return The result of applying the operator.
     * @throws EvalException If the operator is invalid.
     */
    public int op(int o1, int o2) throws EvalException {
		if (addop.equals("+"))
			return o1+o2;
		if (addop.equals("-"))
			return o1-o2;
		throw new EvalException(pos,"bogus addop: "+addop);
	}

	 /**
     * Generates C code representation of the addition or subtraction operation.
     * @return A string containing the operator.
     */
    public String code() { return addop; }

}
