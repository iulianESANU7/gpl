package process;

import data.Block;

/**
 * The block controller class. It controls the entry and the exit of train for the block.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class BlockManager {
	private Block block;
	private TrainManager occupyingTrain = null;

	public BlockManager(Block block) {
		this.block = block;
	}

	/**
	 * Tries to make a train enter into to the block. If the block is not free, the train should wait.
	 * The "synchronized" keyword ensure unique access.
	 * 
	 * @param trainManager the train asking for entry.
	 */
	public synchronized void enter(TrainManager trainManager) {
		if (occupyingTrain != null) {
			// The train asking for entry should wait until the block is freed by its occupying train.
			trainManager.updatePosition(block.getStartPoint());
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}

		// The train leaves and frees its previous block.
		BlockManager previousBlockManager = trainManager.getBlockManager();
		previousBlockManager.exit();

		// The train entries into this block.
		trainManager.setBlockManager(this);
		occupyingTrain = trainManager;
	}

	/**
	 * Makes the occupying train leave and notifies the waiting train.
	 */
	public synchronized void exit() {
		occupyingTrain = null;
		
		// Notify the waiting train (which can enter into the block now).
		notify();
	}

	public boolean isFree() {
		return occupyingTrain == null;
	}

	public int getBlockId() {
		return block.getId();
	}

	public int getLength() {
		return block.getLength();
	}

	public int getStartPoint() {
		return block.getStartPoint();
	}

	public int getEndPoint() {
		return block.getEndPoint();
	}

}
