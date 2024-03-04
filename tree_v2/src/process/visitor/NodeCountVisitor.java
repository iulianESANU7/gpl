package process.visitor;

import data.Addition;
import data.Constant;
import data.Multiplication;
import data.Subtraction;
import data.Tree;
import data.Variable;

/**
 * This visitor can count the total node number of a {@link Tree}.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class NodeCountVisitor implements TreeVisitor<Integer> {
	private int count;

	public NodeCountVisitor() {
		count = 0;
	}

	@Override
	public Integer visit(Constant node) {
		processOperandNode(node);
		return count;
	}

	@Override
	public Integer visit(Variable node) {
		return processOperandNode(node);
	}

	private Integer processOperationNode(Tree node) {
		node.getLeftOperand().accept(this);
		node.getRightOperand().accept(this);
		return ++count;
	}

	private Integer processOperandNode(Tree node) {
		return ++count;
	}

	@Override
	public Integer visit(Addition node) {
		return processOperationNode(node);
	}

	@Override
	public Integer visit(Subtraction node) {
		return processOperationNode(node);
	}

	@Override
	public Integer visit(Multiplication node) {
		return processOperationNode(node);
	}

}
