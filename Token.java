// This class models a token, which has two parts:
// 1) the token itself (e.g., "id" or "+")
// 2) the token's lexeme (e.g., "foo")

/**
 * Represents a token in the lexical analysis phase.
 * A token consists of a type (e.g., "id", "num", "+") and its lexeme (actual text).
 */
public class Token {

	private String token;
	private String lexeme;

	/**
     * Constructs a Token with a specified type and lexeme.
     * @param token The type of the token.
     * @param lexeme The actual text representation of the token.
     */
    public Token(String token, String lexeme) {
		this.token=token;
		this.lexeme=lexeme;
	}

	/**
     * Constructs a Token with a specified type, using the type as the lexeme.
     * @param token The type of the token.
     */
    public Token(String token) {
		this(token,token);
	}

	/**
     * Returns the type of the token.
     * @return The token type.
     */
    public String tok() { return token; }

	/**
     * Returns the lexeme of the token.
     * @return The token lexeme.
     */
    public String lex() { return lexeme; }

	/**
     * Checks if two tokens are equal based on their type.
     * @param t The token to compare.
     * @return True if both tokens have the same type, false otherwise.
     */
    public boolean equals(Token t) {
		return token.equals(t.token);
	}

	/**
     * Returns a string representation of the token.
     * @return A formatted string showing the token type and lexeme.
     */
    public String toString() {
		return "<"+tok()+","+lex()+">";
	}

}
