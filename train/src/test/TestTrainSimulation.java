package test;

import gui.MainGui;

/**
 * The train simulation manuel test class.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TestTrainSimulation {
	public static void main(String[] args) {
		MainGui simulationGUI = new MainGui();
		Thread guiTread = new Thread(simulationGUI);
		guiTread.start();
	}
}
