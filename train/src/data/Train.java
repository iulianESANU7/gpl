package data;

/**
 * This class represents a planned train for the railway line.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Train {
	/**
	 * Train id number.
	 */
	private int id;
	
	/**
	 * Train speed refers to the distance that the train crosses from on time unit to another.
	 */
	private int speed;
	
	/**
	 * The current position of the train on the railway line.
	 */
	private int currentPosition;

	public Train(int id, int speed, int position) {
		this.id = id;
		this.speed = speed;
		this.currentPosition = position;
	}

	public int getId() {
		return id;
	}

	public int getSpeed() {
		return speed;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

}
