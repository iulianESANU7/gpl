package gui;

/**
 * This class contains necessary simulation parameters.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class SimuPara {
	
	public static final int WINDOW_WIDTH = 1800;
	public static final int WINDOW_HEIGHT = 300;
	
	public static final int LINE_TOTAL_LENGTH = 1700;
	
	public static final int BLOCK_LENGTH = 100;
	
	public static final int[] GARE_POSITION = new int [] {200, 500, 800, 1000, 1200, 1500, 1700};
	public static final int STATION_MIN_STAY = 3;
	public static final int STATION_MAX_STAY = 6;
		
	public static final int TRAIN_INTERVALL = 50;
	public static final int TRAIN_MIN_SPEED = 1;
	public static final int TRAIN_MAX_SPEED = 4;
	
	public static final int SIMULATION_DURATION = 2000;
	
	/**
	 * The smaller the value is, the faster the simulation will be.
	 */
	public static final int SIMULATION_SPEED = 20;
	
}
