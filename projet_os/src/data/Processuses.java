package data;

/**
 * This class keeps all Processus(ses) instances running.
 * Uses the Singleton Pattern to keep track of all 
 * processuses. To prevent problemes due to the 
 * multi-threaded nature of the system, this Singleton is renforced 
 * with the double checked looking idiom.
 * 
 * @author iulianESANU
 */
public class Processuses {
	public static volatile Processuses instance;
	
	/**
	 * Static method, enshures to have a unique instance of the class.
	 * 
	 * Notes a moi du futur, faut voir si il y a une valeur de retour
	 * pour cette methode ou non, la je pense que le mieux serait de faire
	 * une autre methode getValue() pour pouvoir obtenir quelque chose pour 
	 * travailler sur les threads.
	 * 
	 * @param Processus data
	 * 		Contains the processus data, may change 
	 * 
	 * @result Processuses instance
	 * 		Returns the unique instance of the class.
	 * 
	 * @author iulianESANU
	 * 
	 */
	public static Processuses getInstance() {
		Processuses result = instance;
		if (result == null) {
			synchronized (Processuses.class) {
				result = instance;
				if (result == null) {
					instance = result = new Processuses();
					
				}
			}
		}
		return result;
	}

}