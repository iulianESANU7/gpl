package gui.elements;

import javax.swing.JFrame;

import process.management.TreeBuilder;
import data.Tree;

/**
 * The graphical tree main frame. It contains a {@link TreePanel} that manages
 * the graphical tree printing.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class GraphicalTree extends JFrame {

	private static final long serialVersionUID = 5193610496520599151L;
	private TreePanel treePanel;

	/**
	 * To create a graphical tree frame, we need to specify the input tree text file.
	 * 
	 * @param input the name of input file with its path
	 */
	public GraphicalTree(String input) {
		super("Graphical Tree Demo");

		TreeBuilder builder = new TreeBuilder(input);
		Tree tree = builder.buildTree();

		treePanel = new TreePanel(tree);

		initLayout();
	}

	private void initLayout() {
		getContentPane().add(treePanel);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
}
