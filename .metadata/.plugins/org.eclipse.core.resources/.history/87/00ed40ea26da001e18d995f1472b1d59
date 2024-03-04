package test.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import data.Tree;
import process.management.TreeBuilder;
import process.visitor.CalculationVisitor;
import process.visitor.HeigtVisitor;
import process.visitor.NodeCountVisitor;
import test.input.InputParameter;

/**
 * This test case tests the three functional Tree visitors.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TestTreeVisitor{
	private Tree tree;
	
	@Before
	public void prepareTree() {
		TreeBuilder builder = new TreeBuilder(InputParameter.INPUT_PATH);
		tree = builder.buildTree();
	}

	@Test
	public void testCalculationVisitor() {
		CalculationVisitor visitor = new CalculationVisitor();
		int result = tree.accept(visitor);
		assertEquals(-4, result);
	}
	
	@Test
	public void testNodeCountVisitor() {
		NodeCountVisitor visitor = new NodeCountVisitor();
		int nodeCount = tree.accept(visitor);
		assertEquals(11, nodeCount);
	}
	
	@Test
	public void testHeightVisitor() {
		HeigtVisitor visitor = new HeigtVisitor();
		tree.accept(visitor);
		assertEquals(3, visitor.getHeight());
	}

}
