package data;

/**
 * The Subtraction operation, sub-class of {@link ArithmeticOperation}.
 * 
 * @see ArithmeticOperation
 * @see Tree
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Subtraction extends ArithmeticOperation {

    public Subtraction(Tree leftOperand, Tree rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public String toString() {
        return getLeftOperand().toString() + " - " + getRightOperand().toString();
    }

    /**
     * To process the subtraction, we need the calculation results of both
     * operands. The result of subtraction will be left result - right result.
     */
    public int calculate() {
        return getLeftOperand().calculate() - getRightOperand().calculate();
    }

}
