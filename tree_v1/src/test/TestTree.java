package test;

import process.TreeBuilder;
import data.Tree;

/**
 * This class tests the following functionalities :
 * 
 * 1) The construction of the tree from an input text file
 * 
 * 2) The toString methods of all tree nodes for formula display
 * 
 * 3) The calculation methods of all tree nodes for calculating the formula
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TestTree {

	public static void main(String[] args) {
		TreeBuilder treeBuilder = new TreeBuilder("src/test/input.txt");
		Tree tree = treeBuilder.buildTree();
		System.out.println(tree.toString() + " = " + tree.calculate());
	}

}
