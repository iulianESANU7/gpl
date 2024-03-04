package process;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import data.Station;
import data.Train;
import gui.SimuPara;

/**
 * This utility class contains unit functions used by the train simulation.
 * 
 * @see SimuPara
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class SimulationUtility {
	
	/**
	 * Reads a image from an image file.
	 * 
	 * @param filePath the path (from "src") of the image file
	 * @return the read file
	 */
	public static Image readImage(String filePath) {
		try {
			return ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("-- Can not read the image file ! --");
			return null;
		}
	}

	/**
	 * Generates a new train with a random speed.
	 * 
	 * @param id the new train's id
	 * @return the generated train
	 */
	public static Train generatorRandomTrain(int id) {
		return new Train(id, getRandom(SimuPara.TRAIN_MIN_SPEED, SimuPara.TRAIN_MAX_SPEED), 0);
	}

	/**
	 * Generates a new station with a random stay time.
	 * 
	 * @param name the new station's name
	 * @param position the new station's position on the railway line
	 * @return the generated station
	 */
	public static Station generateRandomStation(String name, int position) {
		return new Station(name, position, getRandom(SimuPara.STATION_MIN_STAY, SimuPara.STATION_MAX_STAY));
	}

	/**
	 * Simulates the unit time (for an iteration) defined for the simulation. 
	 */
	public static void unitTime() {
		try {
			Thread.sleep(SimuPara.SIMULATION_SPEED);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Simulated the necessary refresh time for avoiding printing issue.
	 */
	public static void windowRefreshTime() {
		try {
			Thread.sleep(SimuPara.SIMULATION_SPEED * 10);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}

	private static int getRandom(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}

}
