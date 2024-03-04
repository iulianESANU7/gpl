package data;

import process.visitor.TreeVisitor;

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

	@Override
	public <T> T accept(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
