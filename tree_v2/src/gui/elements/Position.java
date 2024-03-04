package gui.elements;

/**
 * This class presents the relative current position.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Position {
	private int x;
	private int y;
	
	/**
	 * The relative position takes into account the elementary graphical parameter : scale.
	 */
	private int scale;

	public Position(int x, int y, int scale) {
		this.x = x;
		this.y = y;
		this.scale = scale;
	}

	public int getPositionX() {
		return x * scale;
	}

	public int getPositionY() {
		return y * scale;
	}

	public void moveUp() {
		y--;
	}

	public void moveDown() {
		y++;
	}

	public void moveLeft() {
		x--;
	}

	public void moveRight() {
		x++;
	}

}
