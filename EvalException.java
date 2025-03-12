/**
 * EvalException is thrown when an evaluation error occurs during execution.
 * It stores the position of the error in the source code and an error message.
 */
public class EvalException extends Exception {

	private int pos;
	private String msg;

	/**
     * Constructs an EvalException with a specific position and message.
     * @param pos The position in the source code where the error occurred.
     * @param msg A descriptive message about the evaluation error.
     */
    public EvalException(int pos, String msg) {
		this.pos=pos;
		this.msg=msg;
	}

	/**
     * Returns a formatted string representation of the evaluation error.
     * @return A string containing the error position and message.
     */
    public String toString() {
		return "eval error"
			+", pos="+pos
			+", "+msg;
	}

}
