package process.visitor;

import process.management.VariableRepository;
import data.Addition;
import data.Constant;
import data.Multiplication;
import data.Subtraction;
import data.Variable;

/**
 * This visitor can calculate the formula result reprented by the tree.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class CalculationVisitor implements TreeVisitor<Integer> {

	@Override
	public Integer visit(Constant node) {
		return node.getValue();
	}

	@Override
	public Integer visit(Variable node) {
		VariableRepository variableRepository = VariableRepository.getInstance();
		return variableRepository.getValue(node.getName());
	}

	@Override
	public Integer visit(Addition node) {
		Integer leftResult = node.getLeftOperand().accept(this);
		Integer rightResult = node.getRightOperand().accept(this);
		return leftResult + rightResult;
	}

	@Override
	public Integer visit(Subtraction node) {
		Integer leftResult = node.getLeftOperand().accept(this);
		Integer rightResult = node.getRightOperand().accept(this);
		return leftResult - rightResult;
	}

	@Override
	public Integer visit(Multiplication node) {
		Integer leftResult = node.getLeftOperand().accept(this);
		Integer rightResult = node.getRightOperand().accept(this);
		return leftResult * rightResult;
	}

}
