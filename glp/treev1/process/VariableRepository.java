package process;

import java.util.HashMap;

/**
 * This class manages the values of all known variables in a tree. The class
 * uses Singleton design pattern to maintain the consistency on values.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class VariableRepository {
	/**
	 * This {@link HashMap} contains all registered variable values. The key is
	 * variable name (unique) and the value is the current variable's value.
	 */
	private HashMap<String, Integer> values = new HashMap<String, Integer>();

	/**
	 * The unique instance of the class prepared in an eager way (object created
	 * at beginning).
	 */
	private static VariableRepository instance = new VariableRepository();

	/**
	 * Private constructor ensuring no access from outside of the class.
	 */
	private VariableRepository() {

	}

	/**
	 * Static method allows users to get the unique instance of the class.
	 * 
	 * @return the unique instance of the class.
	 */
	public static VariableRepository getInstance() {
		return instance;
	}

	/**
	 * To register the value for a variable, we specify the variable name and
	 * the expected current value for the variable. If there is already a
	 * registered value for the variable with this name, the old value will be
	 * replaced by the new one.
	 * 
	 * @param name
	 *            the name of the variable for which we wish to register the
	 *            (new) value
	 * @param value
	 *            the value for the variable
	 */
	public void register(String name, int value) {
		values.put(name, value);
	}

	/**
	 * Gets the value for a registered variable. If the variable with the
	 * specified name does not exist in the repository, the method returns 0.
	 * 
	 * @param name
	 *            the name of the variable
	 * @return the current registered value for the variable
	 */
	public int getValue(String name) {
		if (values.containsKey(name)) {
			return values.get(name);
		} else {
			return 0;
		} 	
	}

}
