package process.visitor;

import data.Addition;
import data.ArithmeticOperation;
import data.Constant;
import data.Multiplication;
import data.Subtraction;
import data.Tree;
import data.Variable;

/**
 * This visitor can calculate the {@link Tree} height.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class HeigtVisitor implements TreeVisitor<Void> {
	private int height = 0;
	private int currentHeight = 0;

	public int getHeight() {
		return height;
	}

	@Override
	public Void visit(Constant node) {
		processOperand();
		return null;
	}

	@Override
	public Void visit(Variable node) {
		processOperand();
		return null;
	}
	
	private void processOperand() {
		if (height < currentHeight) {
			height = currentHeight;
		}
	}

	@Override
	public Void visit(Addition node) {
		processArithmeticOperation(node);
		return null;
	}

	@Override
	public Void visit(Subtraction node) {
		processArithmeticOperation(node);
		return null;
	}

	@Override
	public Void visit(Multiplication node) {
		processArithmeticOperation(node);
		return null;
	}

	private void processArithmeticOperation(ArithmeticOperation node) {
		currentHeight++;
		node.getLeftOperand().accept(this);
		node.getRightOperand().accept(this);
		currentHeight--;
	}

}
