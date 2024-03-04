package gui.management;

import java.awt.Color;
import java.awt.Graphics;

import data.Addition;
import data.ArithmeticOperation;
import data.Constant;
import data.Multiplication;
import data.Subtraction;
import data.Variable;

/**
 * This color strategy contains 3 main colors : 
 * 1) Red for {@link Constant} node
 * 2) Blue for {@link Variable} node
 * 3) Black for {@link ArithmeticOperation} node and lines between nodes
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TriColoredStrategy implements ColorStrategy {

	@Override
	public void setColor(Graphics graphics, Constant node) {
		graphics.setColor(Color.RED);
	}

	@Override
	public void setColor(Graphics graphics, Variable node) {
		graphics.setColor(Color.BLUE);

	}

	@Override
	public void setColor(Graphics graphics, Addition node) {
		processOperation(graphics);
	}

	@Override
	public void setColor(Graphics graphics, Subtraction node) {
		processOperation(graphics);

	}

	@Override
	public void setColor(Graphics graphics, Multiplication node) {
		processOperation(graphics);
	}

	@Override
	public void setLineColor(Graphics graphics) {
		graphics.setColor(Color.BLACK);

	}

	private void processOperation(Graphics graphics) {
		graphics.setColor(Color.BLACK);

	}

}
