package data;

import process.VariableRepository;

/**
 * This class represents the Variable node. It contains the simple information
 * about the variable name. The value of the variable is managed in
 * {@link VariableRepository}
 * 
 * @see Operand
 * @see VariableRepository
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Variable extends Operand {
	private String name;

	/**
	 * To create a Variable node, we need to specify the variable name (unique).
	 * 
	 * @param name
	 *            the name of the variable, unique value
	 */
	public Variable(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * To calculate a Variable node, we need to fetch the stocked value of the
	 * variable in {@link VariableRepository}.
	 */
	public int calculate() {
		VariableRepository repository = VariableRepository.getInstance();
		return repository.getValue(name);
	}

}
