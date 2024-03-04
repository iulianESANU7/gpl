package data;

/**
 * This class represents a railway station. 
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Station {
	/**
	 * The railway station's name that starts with "S", followed by a number.
	 */
	private String name;
	
	/**
	 * The location of the railway station.
	 */
	private int position;
	
	/**
	 * The unit time that a train will stay at the station.
	 */
	private int stayTime;

	public Station(String name, int position, int stayTime) {
		this.name = name;
		this.position = position;
		this.stayTime = stayTime;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public int getStayTime() {
		return stayTime;
	}
}
