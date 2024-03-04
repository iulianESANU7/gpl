package gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import process.BlockManager;
import process.Simulation;
import process.SimulationUtility;
import process.TrainManager;

/**
 * The train simulation main GUI.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class MainGui extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	private Simulation simulation;
	private Dashboard dashboard;
	private InfoPanel infoPanel;

	public MainGui() {
		super("Train simulation");
		simulation = new Simulation();
		dashboard = new Dashboard(simulation);
		
		infoPanel = new InfoPanel();

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(BorderLayout.CENTER, dashboard);
		contentPane.add(BorderLayout.SOUTH, infoPanel);
		
		setSize(SimuPara.WINDOW_WIDTH, SimuPara.WINDOW_HEIGHT);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * The entry point of the train simulation.
	 */
	public void run() {
		int time = 0;

		while (time <= SimuPara.SIMULATION_DURATION) {
			SimulationUtility.unitTime();

			if (time % SimuPara.TRAIN_INTERVALL == 0) {
				BlockManager firstBlockManager = simulation.getBlockManager(0);

				if (firstBlockManager.isFree()) {

					TrainManager nextTrain = simulation.getNextTrain();
					nextTrain.setBlockManager(firstBlockManager);
					firstBlockManager.enter(nextTrain);
					
					nextTrain.setRunning(true);
					
					// This is the Thread start.
					nextTrain.start();
				}
			}

			dashboard.repaint();
			time++;
		}
		
		// We need a little more time for avoiding printing delay issue.
		SimulationUtility.windowRefreshTime();
		
		simulation.stopAllTrains();
	}
}
