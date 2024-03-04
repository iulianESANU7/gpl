package process;

import data.Line;
import data.Station;
import data.Train;

/**
 * The train controller class. Each instance of the class represents a train on the railway line.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TrainManager extends Thread {
	private Simulation simulation;
	private Train train;
	private Line line;
	private BlockManager blockManager;

	/**
	 * The trains has arrived at the terminus.
	 */
	private boolean atTerminus = false;
	
	/**
	 * The train departs from the start point.
	 */
	private boolean running = false;

	public TrainManager(Simulation simulation, Train train, Line line) {
		this.simulation = simulation;
		this.train = train;
		this.line = line;
	}

	@Override
	public void run() {
		while (!atTerminus && running) {
			SimulationUtility.unitTime();

			int position = train.getCurrentPosition();
			
			// The train will stay for a while at each station.
			Station station = line.getStation(position);
			if (station != null) {
				for (int stay = 1; stay <= station.getStayTime(); stay++) {
					SimulationUtility.unitTime();
				}
			}
			
			int speed = train.getSpeed();
			int blockEndPoint = blockManager.getEndPoint();

		
			if (position + speed >= blockEndPoint) {
				
				// We need to ask the entry into the block.
				if (blockEndPoint == line.getTotalLength()) {
					atTerminus = true;
				} else {
					BlockManager nextBlockManager = simulation.getBlockManager(blockEndPoint);
					nextBlockManager.enter(this);
				}
			} else {
				
				// The trains advances on the line.
				updatePosition(position + speed);
			}
		}
		
		// The train leaves the last occupied block.
		blockManager.exit();
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void updatePosition(int position) {
		train.setCurrentPosition(position);
	}

	public int getTrainId() {
		return train.getId();
	}

	public int getPosition() {
		return train.getCurrentPosition();
	}

	public BlockManager getBlockManager() {
		return blockManager;
	}

	public void setBlockManager(BlockManager blockManager) {
		this.blockManager = blockManager;
	}

	public boolean isAtTerminus() {
		return atTerminus;
	}
}
