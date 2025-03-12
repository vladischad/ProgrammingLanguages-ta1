// This class is a recursive-descent parser,
// modeled after the programming language's grammar.
// It constructs and has-a Scanner for the program
// being parsed.

/**
 * The Parser class implements a recursive descent parser.
 * It processes tokens from the scanner and builds a parse tree.
 */
public class Parser {

    private Scanner scanner;

    /**
     * Matches the expected token and advances the scanner.
     * @param s The expected token string.
     * @throws SyntaxException If the token does not match the expected value.
     */
    private void match(String s) throws SyntaxException {
        scanner.match(new Token(s));
    }

    /**
     * Returns the current token.
     * @return The current token.
     * @throws SyntaxException If no valid token is found.
     */
    private Token curr() throws SyntaxException {
        return scanner.curr();
    }

    /**
     * Returns the current position in the source code.
     * @return The position of the scanner.
     */
    private int pos() {
        return scanner.pos();
    }

    /**
     * Parses a multiplication or division operator.
     * @return A NodeMulop representing the operator, or null if not found.
     * @throws SyntaxException If parsing fails.
     */
    private NodeMulop parseMulop() throws SyntaxException {
        if (curr().equals(new Token("*"))) {
            match("*");
            return new NodeMulop(pos(), "*");
        }
        if (curr().equals(new Token("/"))) {
            match("/");
            return new NodeMulop(pos(), "/");
        }
        return null;
    }

    /**
     * Parses an addition or subtraction operator.
     * @return A NodeAddop representing the operator, or null if not found.
     * @throws SyntaxException If parsing fails.
     */
    private NodeAddop parseAddop() throws SyntaxException {
        if (curr().equals(new Token("+"))) {
            match("+");
            return new NodeAddop(pos(), "+");
        }
        if (curr().equals(new Token("-"))) {
            match("-");
            return new NodeAddop(pos(), "-");
        }
        return null;
    }

    /**
     * Parses a factor (number, identifier, parenthesized expression, or unary minus).
     * @return A NodeFact representing the parsed factor.
     * @throws SyntaxException If parsing fails.
     */
    private NodeFact parseFact() throws SyntaxException {
        if (curr().equals(new Token("-"))) {
            match("-");
            return new NodeFactUnaryMinus(parseFact());
        }
        if (curr().equals(new Token("("))) {
            match("(");
            NodeExpr expr = parseExpr();
            match(")");
            return new NodeFactExpr(expr);
        }
        if (curr().equals(new Token("id"))) {
            Token id = curr();
            match("id");
            return new NodeFactId(pos(), id.lex());
        }
        Token num = curr();
        match("num");
        return new NodeFactNum(num.lex());
    }

    /**
     * Parses a term (factor with optional multiplication or division).
     * @return A NodeTerm representing the parsed term.
     * @throws SyntaxException If parsing fails.
     */
    private NodeTerm parseTerm() throws SyntaxException {
        NodeFact fact = parseFact();
        NodeMulop mulop = parseMulop();
        if (mulop == null)
            return new NodeTerm(fact, null, null);
        NodeTerm term = parseTerm();
        term.append(new NodeTerm(fact, mulop, null));
        return term;
    }

    /**
     * Parses an expression (term with optional addition or subtraction).
     * @return A NodeExpr representing the parsed expression.
     * @throws SyntaxException If parsing fails.
     */
    private NodeExpr parseExpr() throws SyntaxException {
        NodeTerm term = parseTerm();
        NodeAddop addop = parseAddop();
        if (addop == null)
            return new NodeExpr(term, null, null);
        NodeExpr expr = parseExpr();
        expr.append(new NodeExpr(term, addop, null));
        return expr;
    }

    /**
     * Parses an assignment statement.
     * @return A NodeAssn representing the parsed assignment.
     * @throws SyntaxException If parsing fails.
     */
    private NodeAssn parseAssn() throws SyntaxException {
        Token id = curr();
        match("id");
        match("=");
        NodeExpr expr = parseExpr();
        return new NodeAssn(id.lex(), expr);
    }

    /**
     * Parses a statement (assignment followed by a semicolon).
     * @return A NodeStmt representing the parsed statement.
     * @throws SyntaxException If parsing fails.
     */
    private NodeStmt parseStmt() throws SyntaxException {
        NodeAssn assn = parseAssn();
        match(";");
        return new NodeStmt(assn);
    }

    /**
     * Parses a program into a parse tree.
     * @param program The source code as a string.
     * @return The root node of the parse tree.
     * @throws SyntaxException If parsing fails.
     */
    public Node parse(String program) throws SyntaxException {
        scanner = new Scanner(program);
        scanner.next();
        NodeStmt stmt = parseStmt();
        match("EOF");
        return stmt;
    }
}
