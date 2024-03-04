package gui.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import process.management.TreeBuilder;
import data.Tree;
import gui.instrument.ChartManager;
import gui.instrument.InstrumentVisitor;

/**
 * The graphical tree main frame. It contains a {@link TreePanel} that manages the graphical tree printing.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class GraphicalTree extends JFrame {

	private static final long serialVersionUID = 1L;

	private TreePanel treePanel;
	
	/**
	 * The sub-window for instrument charts.
	 */
	private JPanel statsPanel = new JPanel();
	
	private ChartPanel typeCountPie;
	private ChartPanel typeCountBar;
	private ChartPanel heightEvolutionChart;

	private ChartManager chartManager = new ChartManager();

	/**
	 * To create a graphical tree frame, we need to specify the input tree text file.
	 * 
	 * @param input the name of input file with its path
	 */
	public GraphicalTree(String input) {
		super("Graphical Tree Demo");

		TreeBuilder builder = new TreeBuilder(input);
		Tree tree = builder.buildTree();

		InstrumentVisitor instrumentVisitor = new InstrumentVisitor(chartManager);
		tree.accept(instrumentVisitor);

		treePanel = new TreePanel(tree);

		globalLayout();
	}

	private void globalLayout() {
		getContentPane().setPreferredSize(new Dimension(GTParameters.WINDOW_WIDTH, GTParameters.WINDOW_HEIGHT));
		treePanel.setBackground(Color.WHITE);

		statsPanel.setLayout(new GridLayout(1, 3));

		typeCountPie = new ChartPanel(chartManager.getTypeCountPie());
		typeCountBar = new ChartPanel(chartManager.getTypeCountBar());
		heightEvolutionChart = new ChartPanel(chartManager.getHeightEvolutionChart());

		statsPanel.add(typeCountPie);
		statsPanel.add(typeCountBar);
		statsPanel.add(heightEvolutionChart);

		getContentPane().setLayout(new GridLayout(2, 1));
		getContentPane().add(treePanel);
		getContentPane().add(statsPanel);

		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
}
