package data;

/**
 * The Addition operation, sub-class of {@link ArithmeticOperation}.
 * 
 * @see ArithmeticOperation
 * @see Tree
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Addition extends ArithmeticOperation {

	public Addition(Tree leftOperand, Tree rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	public String toString() {
		return getLeftOperand().toString() + " + " + getRightOperand().toString();
	}

	/**
	 * To process the addition, we need the calculation results of both
	 * operands. The result of addition will be left result + right result.
	 */
	public int calculate() {
		return getLeftOperand().calculate() + getRightOperand().calculate();
	}

}
