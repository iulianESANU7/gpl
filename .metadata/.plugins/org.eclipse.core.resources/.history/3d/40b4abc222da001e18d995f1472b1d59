package data;

import process.visitor.TreeVisitor;

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

	@Override
	public <T> T accept(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
