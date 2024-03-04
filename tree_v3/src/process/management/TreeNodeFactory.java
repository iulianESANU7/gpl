package process.management;

import org.apache.log4j.Logger;

import data.Addition;
import data.ArithmeticOperation;
import data.Constant;
import data.Multiplication;
import data.Subtraction;
import data.Tree;
import data.Variable;
import log.LoggerUtility;

/**
 * This utility class allows the creation of tree node of any concrete type. The class uses simple factory design pattern with static utility methods.
 * 
 * The creation of the tree nodes is recorded by Log4j.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TreeNodeFactory {

	/**
	 * Retrieves the logger for writing logs in
	 * 
	 * 1) a text file ("text" for the logger name) 2) or in a html file ("html" for the logger name);
	 */
	private static Logger logger = LoggerUtility.getLogger(TreeNodeFactory.class, "html");

	private static final char MULTIPLICATION_SYMBOL = '*';
	private static final char SUBTRACTION_SYMBOL = '-';
	private static final char ADDITION_SYMBOL = '+';

	/**
	 * Creates a Constant node.
	 * 
	 * @param value the constant integer value
	 * @return the constructed node
	 */
	public static Constant createConstant(int value) {
		logger.info("Constant creation with value : " + value);
		return new Constant(value);
	}

	/**
	 * Creates a Variable node.
	 * 
	 * @param name the name of the variable
	 * @return the constructed node
	 */
	public static Variable createVariable(String name) {
		logger.info("Variable creation with name : " + name);
		return new Variable(name);
	}

	/**
	 * Create a concrete arithmetic operation. The supported operations are Addition, Subtraction and Multiplication.
	 * 
	 * @param type         the operation type, that can '+', '-' or '*'.
	 * @param leftOperand  the left sub-tree as left operand of the operation
	 * @param rightOperand the right sub-tree as right operand
	 * @return the constructed node with left operand and right operand
	 * @throws IllegalArgumentException if an unknown type (char) is asked, this exception will occur
	 */
	public static ArithmeticOperation createOperation(char type, Tree leftOperand, Tree rightOperand) throws IllegalArgumentException {
		switch (type) {
		case ADDITION_SYMBOL:
			logger.info("Addition operation creation");
			return new Addition(leftOperand, rightOperand);
		case SUBTRACTION_SYMBOL:
			logger.info("Subtraction operation creation");
			return new Subtraction(leftOperand, rightOperand);
		case MULTIPLICATION_SYMBOL:
			logger.info("Multiplication operation creation");
			return new Multiplication(leftOperand, rightOperand);
		default:
			throw new IllegalArgumentException("Unknown operation type : " + type);
		}
	}
}
