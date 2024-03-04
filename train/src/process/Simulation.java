package process;

import java.util.ArrayList;
import java.util.HashMap;

import data.Block;
import data.Line;
import data.Train;
import gui.SimuPara;

/**
 * The simulation management class. Its contains and prepares all {@link BlockManager} and all {@link TrainManager}.
 * 
 * The class has also some basic operations needed by the train simulation.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Simulation {
	private Line line;
	private volatile ArrayList<BlockManager> blockManagers = new ArrayList<BlockManager>();
	private volatile HashMap<Integer, BlockManager> blockManagersByPosition = new HashMap<Integer, BlockManager>();

	private ArrayList<TrainManager> trainManagers = new ArrayList<TrainManager>();

	public Simulation() {
		LineBuilder lineBuilder = new LineBuilder();
		lineBuilder.buildLine(SimuPara.LINE_TOTAL_LENGTH, SimuPara.BLOCK_LENGTH);
		line = lineBuilder.getBuiltLine();

		int position = 0;
		while (position < line.getTotalLength()) {
			if (position % SimuPara.BLOCK_LENGTH == 0) {
				Block block = line.getBlock(position);
				BlockManager blockManager = new BlockManager(block);
				blockManagers.add(blockManager);
				blockManagersByPosition.put(position, blockManager);
			}
			position++;
		}

		int trainCount = SimuPara.SIMULATION_DURATION / SimuPara.TRAIN_INTERVALL;
		for (int count = 1; count <= trainCount; count++) {
			Train train = SimulationUtility.generatorRandomTrain(count);
			TrainManager trainManager = new TrainManager(this, train, line);
			trainManagers.add(trainManager);
		}

	}
	
	public void stopAllTrains() {
		for (TrainManager trainManager : trainManagers) {
			trainManager.setRunning(false);
		}
	}

	public BlockManager getBlockManager(int position) {
		return blockManagersByPosition.get(position);
	}

	public TrainManager getNextTrain() {
		for (TrainManager trainManager : trainManagers) {
			if (!trainManager.isRunning()) {
				return trainManager;
			}
		}
		return null;
	}

	public ArrayList<TrainManager> getTrainManagers() {
		return trainManagers;
	}

	public ArrayList<BlockManager> getBlockManagers() {
		return blockManagers;
	}

	public Line getLine() {
		return line;
	}
}
