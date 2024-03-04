package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import data.Station;
import process.BlockManager;
import process.Simulation;
import process.SimulationUtility;
import process.TrainManager;

/**
 * This class is the panel in which railway line (including blocks and stations) and trains are printed.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Dashboard extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Printing start X position.
	 */
	private static final int START_X = 20;
	
	/**
	 * Printing start Y position.
	 */
	private static final int START_Y = 100;

	private Simulation simulation;

	public Dashboard(Simulation simulation) {
		this.simulation = simulation;
		setBackground(Color.WHITE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// We used Graphic2D for more draw options.
		Graphics2D g2 = (Graphics2D) g;
		printLine(g2);
		printTrains(g2);
	}

	private void printLine(Graphics2D g2) {
		g2.setColor(Color.BLUE);
		g2.setStroke(new BasicStroke(8));
		g2.drawLine(START_X, START_Y, START_X + simulation.getLine().getTotalLength(), START_Y);

		for (BlockManager blockManager : simulation.getBlockManagers()) {

			int startPoint = blockManager.getStartPoint();

			// Draw signals with different colors.
			if (blockManager.isFree()) {
				g2.setColor(Color.GREEN);
				g2.drawOval(START_X + startPoint, START_Y - 20, 10, 10);
			} else {
				g2.setColor(Color.RED);
				g2.drawOval(START_X + startPoint, START_Y - 20, 10, 10);
			}

			g2.drawLine(START_X + startPoint + 5, START_Y - 20, START_X + startPoint + 5, START_Y);

			g2.setColor(Color.BLUE);
			g2.setFont(new Font("Dialog", Font.PLAIN, 20));
			g2.drawString("B" + blockManager.getBlockId(), startPoint + 50, START_Y + 30);
		}

		ArrayList<Station> stations = simulation.getLine().getStations();
		for (Station station : stations) {
			int stationPosition = station.getPosition();
			g2.drawImage(SimulationUtility.readImage("src/images/station.png"), START_X + stationPosition - 5, START_Y - 10, 20, 40, null);
			g2.drawString(station.getName(), stationPosition + 10, START_Y + 50);
		}
	}

	private void printTrains(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(6));

		for (TrainManager trainManager : simulation.getTrainManagers()) {
			// Only the trains running on the line will be drawn.
			if (trainManager.isRunning() && !trainManager.isAtTerminus()) {
				g2.setFont(new Font("Dialog", Font.PLAIN, 20));
				int position = trainManager.getPosition();

				// Attention : don't call trainManager.getId(), because it will return the ID of the thread (not the train).
				g2.drawString("T" + trainManager.getTrainId(), position, START_Y - 30);
				g2.drawImage(SimulationUtility.readImage("src/images/train.jpg"), START_X + position - 30, START_Y - 25, 40, 20, null);
			}

		}
	}
}
