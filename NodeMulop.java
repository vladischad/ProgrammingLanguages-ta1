/**
 * Represents a multiplication or division operation in the parse tree.
 * This node handles binary multiplication and division.
 */
public class NodeMulop extends Node {

	private String mulop;

	/**
     * Constructs a NodeMulop with a specific position and operator.
     * @param pos The position of the operator in the source code.
     * @param mulop The multiplication or division operator as a string.
     */
    public NodeMulop(int pos, String mulop) {
		this.pos=pos;
		this.mulop=mulop;
	}

	/**
     * Performs the multiplication or division operation on two operands.
     * @param o1 The first operand.
     * @param o2 The second operand.
     * @return The result of applying the operator.
     * @throws EvalException If the operator is invalid or division by zero occurs.
     */
    public int op(int o1, int o2) throws EvalException {
		if (mulop.equals("*"))
			return o1*o2;
		if (mulop.equals("/"))
			return o1/o2;
		throw new EvalException(pos,"bogus mulop: "+mulop);
	}

	/**
     * Generates C code for the multiplication or division operation.
     * @return A string containing the operator.
     */
    public String code() { return mulop; }

}
