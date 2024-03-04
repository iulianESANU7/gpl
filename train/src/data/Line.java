package data;

import java.util.ArrayList;
import java.util.HashMap;

import gui.SimuPara;
import process.SimulationUtility;

/**
 * This class represents a railway line that includes blocks and railway stations.
 * 
 * The blocks have the same length (except the last one that can be shorter).
 * 
 * The stations are located at specified positions.
 * 
 * @see SimuPara
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Line {
	private int totalLength;
	
	/**
	 * The part filled by blocks.
	 */
	private int usedLength = 0;

	/**
	 * The key is the start point of the block.
	 */
	private HashMap<Integer, Block> blocks = new HashMap<Integer, Block>();

	private ArrayList<Station> stations = new ArrayList<Station>();

	/**
	 * The key is the position of the station. This is not the replica of the stations. They are just the same references in {@link HashMap} form.
	 */
	private HashMap<Integer, Station> stationMap = new HashMap<Integer, Station>();

	public Line(int totalLenght) {
		this.totalLength = totalLenght;
	}

	public void addBlock(int id, int blockLength) {
		int startPoint = usedLength;
		int endPoint;

		if (usedLength + blockLength <= totalLength) {
			endPoint = usedLength + blockLength;
			usedLength += blockLength;
		} else {
			// The last block will be shorter than expected.
			endPoint = usedLength + (totalLength - usedLength);
			usedLength = totalLength;
		}

		Block block = new Block(id, startPoint, endPoint);
		blocks.put(startPoint, block);
	}

	public void addStation(String name, int position) {
		Station station = SimulationUtility.generateRandomStation(name, position);
		stations.add(station);
		stationMap.put(position, station);
	}

	public boolean lineFilled() {
		return usedLength == totalLength;
	}

	public int getTotalLength() {
		return totalLength;
	}

	public int getUsedLength() {
		return usedLength;
	}

	public Block getBlock(int startPoint) {
		return blocks.get(startPoint);
	}

	public ArrayList<Station> getStations() {
		return stations;
	}

	public Station getStation(int position) {
		return stationMap.get(position);
	}

}
