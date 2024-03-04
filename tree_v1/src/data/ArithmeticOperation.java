package data;

/**
 * This class represents all arithmetic operations including Addition,
 * Subtraction and Multiplication. All these operations need two operands
 * (sub-trees) to process the calculation.
 * 
 * The class uses Template Method design pattern. The common part (left operand
 * and right operand) is defined in this class and is shared in the sub-classes.
 * 
 * No default toString() defined.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public abstract class ArithmeticOperation implements Tree {
	/**
	 * Left operand of the operation (sub-tree)
	 */
	private Tree leftOperand;

	/**
	 * Right operand of the operation (sub-tree)
	 */
	private Tree rightOperand;

	/**
	 * We need two operands (sub-trees) to construct an arithmetic operation.
	 * The constructed operation becomes the new parent tree node of the two
	 * operands.
	 * 
	 * @param leftOperand
	 *            left sub-tree
	 * @param rightOperand
	 *            right sub-tree
	 */
	public ArithmeticOperation(Tree leftOperand, Tree rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	public Tree getLeftOperand() {
		return leftOperand;
	}

	public Tree getRightOperand() {
		return rightOperand;
	}

	public void setRightOperand(Tree rightOperand) {
		this.rightOperand = rightOperand;
	}

	public void setLeftOperand(Tree leftOperand) {
		this.leftOperand = leftOperand;
	}
}
