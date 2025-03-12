/**
 * Represents a factor that is a unary minus operation.
 * This node negates the result of an expression.
 */
public class NodeFactUnaryMinus extends NodeFact {

    private NodeFact fact; // The factor being negated

    /**
     * Constructs a NodeFactUnaryMinus with a factor.
     * @param fact The factor to be negated.
     */
    public NodeFactUnaryMinus(NodeFact fact) {
        this.fact = fact;
    }

    /**
     * Evaluates the factor and negates the result.
     * @param env The environment where variables are stored.
     * @return The negated value of the evaluated factor.
     * @throws EvalException If an evaluation error occurs.
     */
    @Override
    public int eval(Environment env) throws EvalException {
        return -fact.eval(env);
    }

    /**
     * Generates C code for the unary minus operation.
     * @return A string containing the C code representation.
     */
    public String code() {
        return "-(" + fact.code() + ")";
    }
}
