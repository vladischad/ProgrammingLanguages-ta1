/**
 * Represents a syntax error encountered during parsing.
 * This exception stores the position of the error, the expected token, and the found token.
 */
public class SyntaxException extends Exception {

	private int pos;
	private Token expected;
	private Token found;

	/**
     * Constructs a SyntaxException with the error position, expected token, and found token.
     * @param pos The position in the source code where the error occurred.
     * @param expected The token that was expected at this position.
     * @param found The token that was actually found.
     */
    public SyntaxException(int pos, Token expected, Token found) {
		this.pos=pos;
		this.expected=expected;
		this.found=found;
	}

	/**
     * Returns a formatted string representation of the syntax error.
     * @return A string describing the error, including position, expected, and found tokens.
     */
    public String toString() {
		return "syntax error"
			+", pos="+pos
			+", expected="+expected
			+", found="+found;
	}

}
