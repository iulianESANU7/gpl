package test.manual;

import data.Tree;
import process.management.TreeBuilder;
import process.visitor.CalculationVisitor;
import process.visitor.HeigtVisitor;
import process.visitor.NodeCountVisitor;
import process.visitor.TreeVisitor;
import test.input.InputParameter;

/**
 * This class tests the tree building, and the tree visitors for 1) formula
 * result calculation 2) tree height calculation 3) tree nodes' count
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TestTree {

	public static void main(String[] args) {
		TreeBuilder builder = new TreeBuilder(InputParameter.INPUT_PATH);
		Tree tree = builder.buildTree();

		TreeVisitor<Integer> visitor = new CalculationVisitor();
		String stringResult = tree.toString();

		Integer calculationResult = tree.accept(visitor);
		System.out.println(stringResult + " = " + calculationResult);

		HeigtVisitor heightVisitor = new HeigtVisitor();
		tree.accept(heightVisitor);
		System.out.println("Tree height : " + heightVisitor.getHeight());

		NodeCountVisitor nodeCountVisitor = new NodeCountVisitor();
		System.out.println("Node count : " + tree.accept(nodeCountVisitor));

	}
}
