package data;

/**
 * This class represents a block on the railway line.
 * 
 * There can be only one train in the block at the same time.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Block {
	/**
	 * The id number of the block
	 */
	private int id;
	
	/**
	 * The start position point of the block
	 */
	private int startPoint;
	
	/**
	 * The end position point of the block
	 */
	private int endPoint;

	public Block(int id, int startPoint, int endPoint) throws IllegalArgumentException {
		if (startPoint < endPoint) {
			this.id = id;
			this.startPoint = startPoint;
			this.endPoint = endPoint;
		} else {
			throw new IllegalArgumentException("Invalid block !");
		}
	}

	public int getId() {
		return id;
	}

	public int getStartPoint() {
		return startPoint;
	}

	public int getEndPoint() {
		return endPoint;
	}

	public int getLength() {
		return endPoint - startPoint;
	}

}
