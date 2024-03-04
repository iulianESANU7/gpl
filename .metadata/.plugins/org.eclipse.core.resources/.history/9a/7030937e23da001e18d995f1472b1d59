package gui.management;

import gui.elements.GTParameters;
import gui.elements.Position;

import java.awt.Graphics;

import process.visitor.TreeVisitor;
import data.Addition;
import data.ArithmeticOperation;
import data.Constant;
import data.Multiplication;
import data.Subtraction;
import data.Variable;

/**
 * This visitor print the nodes of a tree.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class PaintVisitor implements TreeVisitor<Void> {
	private Graphics graphics;
	private Position position;
	private int treeHeight;
	private int currentHeight = 0;

	/**
	 * The color strategy used to define the colors of nodes and lines of the
	 * tree.
	 */
	private ColorStrategy colorStrategy = new TriColoredStrategy();

	public PaintVisitor(Graphics graphics, Position posito, int treeHeight) {
		this.graphics = graphics;
		this.position = posito;
		this.treeHeight = treeHeight;
	}

	@Override
	public Void visit(Constant operation) {
		colorStrategy.setColor(graphics, operation);
		printCercle();
		int ajustedPositionX = position.getPositionX() - GTParameters.STRING_AJUSTEMENT;
		int ajustedPositionY = position.getPositionY() + GTParameters.STRING_AJUSTEMENT;
		graphics.drawString(String.valueOf(operation.getValue()), ajustedPositionX,
				ajustedPositionY);
		return null;
	}

	@Override
	public Void visit(Variable operation) {
		colorStrategy.setColor(graphics, operation);
		printCercle();
		int ajustedPositionX = position.getPositionX() - GTParameters.STRING_AJUSTEMENT;
		int ajustedPositionY = position.getPositionY() + GTParameters.STRING_AJUSTEMENT;
		graphics.drawString(String.valueOf(operation.getName()), ajustedPositionX, ajustedPositionY);
		return null;
	}

	@Override
	public Void visit(Addition operation) {
		colorStrategy.setColor(graphics, operation);
		processArithmeticOperation(operation);
		printArithmeticOperation("+", GTParameters.ADDITION_STRING_AJUSTEMENT,
				GTParameters.ADDITION_STRING_AJUSTEMENT);
		return null;
	}

	@Override
	public Void visit(Subtraction operation) {
		colorStrategy.setColor(graphics, operation);
		processArithmeticOperation(operation);
		printArithmeticOperation("-", GTParameters.SUBTRACTION_AJUSTEMENT,
				(int) (GTParameters.SUBTRACTION_AJUSTEMENT * 1.5));
		return null;
	}

	@Override
	public Void visit(Multiplication operation) {
		colorStrategy.setColor(graphics, operation);
		processArithmeticOperation(operation);
		colorStrategy.setColor(graphics, operation);
		printArithmeticOperation("*", GTParameters.MULTIPLICATION_AJUSTEMENT,
				GTParameters.MULTIPLICATION_AJUSTEMENT * 3);
		return null;
	}

	private void processArithmeticOperation(ArithmeticOperation operation) {

		printCercle();

		int currentPositionX = position.getPositionX();
		int currentPositionY = position.getPositionY();
		for (int leftIndex = 1; leftIndex <= Math.pow(2, treeHeight - currentHeight - 1); leftIndex++) {
			position.moveLeft();
		}
		position.moveDown();
		colorStrategy.setLineColor(graphics);
		graphics.drawLine(currentPositionX, currentPositionY, position.getPositionX(),
				position.getPositionY());

		currentHeight++;
		operation.getLeftOperand().accept(this);
		currentHeight--;

		for (int rightIndex = 1; rightIndex <= Math.pow(2, treeHeight - currentHeight); rightIndex++) {
			position.moveRight();
		}

		colorStrategy.setLineColor(graphics);
		graphics.drawLine(currentPositionX, currentPositionY, position.getPositionX(),
				position.getPositionY());

		currentHeight++;
		operation.getRightOperand().accept(this);
		currentHeight--;

		position.moveUp();
		for (int centralIndex = 1; centralIndex <= Math.pow(2, treeHeight - currentHeight - 1); centralIndex++) {
			position.moveLeft();
		}
	}

	private void printCercle() {
		graphics.drawOval(position.getPositionX() - GTParameters.RADIUS / 2,
				position.getPositionY() - GTParameters.RADIUS / 2, GTParameters.RADIUS,
				GTParameters.RADIUS);
	}

	private void printArithmeticOperation(String symbol, int xGap, int yGap) {
		graphics.drawString(symbol, position.getPositionX() - xGap, position.getPositionY() + yGap);
	}
}
