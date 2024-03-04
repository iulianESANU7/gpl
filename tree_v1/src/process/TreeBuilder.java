package process;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import data.ArithmeticOperation;
import data.Multiplication;
import data.Tree;

/**
 * This class builds the binary tree based on an input text file.
 * 
 * The input file contains information about the formula and variables (with
 * their initial values).
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 * 
 */
public class TreeBuilder {
	private String formula;
	private VariableRepository variableRepository = VariableRepository.getInstance();

	/**
	 * The constructor ensures the preparation work for tree building.
	 * 
	 * @param fileName
	 *            the name of the input file that contains tree information
	 */
	public TreeBuilder(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.startsWith("F")) {
					// Save the initial value of variables for further use.
					int equalIndex = line.indexOf("=");
					String variableName = line.substring(0, equalIndex);
					int variableValue = Integer.valueOf(line.substring(equalIndex + 1));
					variableRepository.register(variableName, variableValue);
				} else {
					// Save the formula.
					formula = line.substring(2);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Implementation of tree construction algorithm.
	 * 
	 * @return the constructed tree, represented recursively by the root node
	 */
	public Tree buildTree() {
		Stack<Tree> stack = new Stack<Tree>();

		String constantValue = "";
		String variableName = "";

		for (int index = 0; index < formula.length(); index++) {
			// The current char in the formula to process
			String currentChar = formula.substring(index, index + 1);

			if (!isArithmeticOperation(currentChar)) {
				// Verify if it is the end of the formula or the end of the
				// constant chain / variable chain.
				boolean end = ((index + 1) == formula.length())
						|| (isArithmeticOperation(formula.substring(index + 1, index + 2)));

				Tree operand = null;
				if (isConstant(currentChar)) {
					constantValue += currentChar;
					if (end) {
						// All numbers are gathered, create the constant
						int intValue = Integer.valueOf(constantValue);
						operand = TreeNodeFactory.createConstant(intValue);
						constantValue = "";
					}
				} else if (isVariable(currentChar)) {
					variableName += currentChar;
					if (end) {
						// All letters are gathered, create the variable
						operand = TreeNodeFactory.createVariable(variableName);
						variableName = "";
					}
				}

				if (end) {
					if (stack.isEmpty()) {
						// This is the case at beginning.
						stack.push(operand);
					} else {
						Tree peek = stack.peek();
						if (peek instanceof Multiplication) {
							((Multiplication) peek).setRightOperand(operand);
						} else {
							stack.push(operand);
						}
					}
				}
			} else {
				// We need two different treatments for * and +/-
				if (currentChar.equals("*")) {
					// Create the * with the existing left operand.
					// The right operand will be null for the moment.
					Tree pop = stack.pop();
					ArithmeticOperation operation = TreeNodeFactory.createOperation(
							currentChar.charAt(0), pop, null);
					stack.push(operation);
				} else {
					// Process operations addition(+) or subtraction(-).
					if (stack.size() == 2) {
						Tree rightOperand = stack.pop();
						ArithmeticOperation operation = (ArithmeticOperation) stack.pop();
						operation.setRightOperand(rightOperand);
						ArithmeticOperation newOperation = TreeNodeFactory.createOperation(
								currentChar.charAt(0), operation, null);
						stack.push(newOperation);
					} else {
						Tree leftOperand = stack.pop();
						ArithmeticOperation operation = TreeNodeFactory.createOperation(
								currentChar.charAt(0), leftOperand, null);
						stack.push(operation);
					}
				}
			}
		}

		// The last step for merge the two arithmetic operations.
		if (stack.size() == 2) {
			Tree rightOperand = stack.pop();
			ArithmeticOperation operation = (ArithmeticOperation) stack.peek();
			operation.setRightOperand(rightOperand);
		}

		// Return the root of the tree (the root IS the tree).
		return stack.pop();
	}

	private boolean isConstant(String value) {
		try {
			Integer.valueOf(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isArithmeticOperation(String value) {
		return value.equals("*") || value.equals("+") || value.equals("-");
	}

	private boolean isVariable(String value) {
		return (!isConstant(value)) && (!isArithmeticOperation(value));
	}
}
