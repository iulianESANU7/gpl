package process;

import data.Addition;
import data.ArithmeticOperation;
import data.Constant;
import data.Multiplication;
import data.Subtraction;
import data.Tree;
import data.Variable;

/**
 * This utility class allows the creation of tree node of any concrete type. The
 * class uses simple factory design pattern with static utility methods.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TreeNodeFactory {
	private static final char MULTIPLICATION_SYMBOL = '*';
	private static final char SUBTRACTION_SYMBOL = '-';
	private static final char ADDITION_SYMBOL = '+';

	/**
	 * Creates a Constant node.
	 * 
	 * @param value
	 *            the constant integer value
	 * @return the constructed node
	 */
	public static Constant createConstant(int value) {
		return new Constant(value);
	}

	/**
	 * Creates a Variable node.
	 * 
	 * @param name
	 *            the name of the variable
	 * @return the constructed node
	 */
	public static Variable createVariable(String name) {
		return new Variable(name);
	}

	/**
	 * Create a concrete arithmetic operation. The supported operations are
	 * Addition, Subtraction and Multiplication.
	 * 
	 * @param type
	 *            the operation type, that can '+', '-' or '*'.
	 * @param leftOperand
	 *            the left sub-tree as left operand of the operation
	 * @param rightOperand
	 *            the right sub-tree as right operand
	 * @return the constructed node with left operand and right operand
	 * @throws IllegalArgumentException
	 *             if an unknown type (char) is asked, this exception will occur
	 */
	public static ArithmeticOperation createOperation(char type, Tree leftOperand, Tree rightOperand)
			throws IllegalArgumentException {
		switch (type) {
		case ADDITION_SYMBOL:
			return new Addition(leftOperand, rightOperand);
		case SUBTRACTION_SYMBOL:
			return new Subtraction(leftOperand, rightOperand);
		case MULTIPLICATION_SYMBOL:
			return new Multiplication(leftOperand, rightOperand);
		default:
			throw new IllegalArgumentException("Unknown operation type : " + type);
		}
	}
}
