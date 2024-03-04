package gui.elements;

import gui.management.PaintVisitor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import data.Tree;

import process.visitor.HeigtVisitor;

/**
 * This class represents the sub-window of the graphical tree.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TreePanel extends JPanel {

	private static final long serialVersionUID = -541698616292452515L;
	private Tree tree;
	private int treeHeight;

	/**
	 * Showing the grid will make the debug easier.
	 */
	private boolean debugGrid = true;

	public TreePanel(Tree tree) {
		int windowWidth = GTParameters.WINDOW_WIDTH;

		this.tree = tree;
		HeigtVisitor hightVistor = new HeigtVisitor();
		tree.accept(hightVistor);
		treeHeight = hightVistor.getHeight();

		setPreferredSize(new Dimension(windowWidth, GTParameters.WINDOW_HEIGHT));
		setBackground(Color.WHITE);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Dialog", Font.PLAIN, GTParameters.POLICE_SIZE));
		g.setColor(Color.BLUE);

		if (debugGrid) {
			drawDebugGrid(g);
		}

		PaintVisitor paintVisitor = new PaintVisitor(g, GTParameters.START_POINT, treeHeight);
		tree.accept(paintVisitor);

	}

	private void drawDebugGrid(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		g.setColor(Color.GRAY);

		for (int i = GTParameters.SCALE; i <= width; i += GTParameters.SCALE) {
			g.drawLine(i, 1, i, height);
		}

		for (int i = GTParameters.SCALE; i <= height; i += GTParameters.SCALE) {
			g.drawLine(1, i, width, i);
		}
	}
}
