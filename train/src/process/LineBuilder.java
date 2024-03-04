package process;

import data.Line;
import gui.SimuPara;

/**
 * This class allows a complete railway line construction.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class LineBuilder {
	private Line line;

	public void buildLine(int totalLength, int blockLength) {
		line = new Line(totalLength);
		
		// Build the blocks.
		int id = 1;
		while (!line.lineFilled()) {
			line.addBlock(id, blockLength);
			id++;
		}

		// Build the stations.
		int stationNumber = 1;
		for (int stationPosition : SimuPara.GARE_POSITION) {
			line.addStation("S" + stationNumber, stationPosition);
			stationNumber++;
		}
	}

	public Line getBuiltLine() {
		return line;
	}
}
