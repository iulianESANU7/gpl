package test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import data.Addition;
import data.Constant;
import data.Multiplication;
import data.Subtraction;
import data.Tree;
import data.Variable;
import process.management.TreeBuilder;
import test.input.InputParameter;

/**
 * Unit test of tree building. Each node of the built tree is verified.
 * 
 * The test is based on the formula : 2X+3Y-4Z
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TestTreeBuild {
	private Tree tree;

	@Before
	public void prepareTree() {
		TreeBuilder builder = new TreeBuilder(InputParameter.INPUT_PATH);
		tree = builder.buildTree();
	}

	@Test
	public void testTreeLevel0() {
		assertNotNull(tree);
		assertTrue(tree instanceof Subtraction);
	}
	
	@Test
	public void testTreeLevel1() {
		Tree leftOperand = tree.getLeftOperand();
		Tree rightOperand = tree.getRightOperand();
			
		assertTrue(leftOperand instanceof Addition);
		assertTrue(rightOperand instanceof Multiplication);
	}
	
	@Test
	public void testTreeLevel2() {
		Tree leftOperand = tree.getLeftOperand();
		Tree rightOperand = tree.getRightOperand();
		
		Tree leftOperand1 = leftOperand.getLeftOperand();
		Tree rightOperand2 = leftOperand.getRightOperand();
		
		assertTrue(leftOperand1 instanceof Multiplication); 
		assertTrue(rightOperand2 instanceof Multiplication);
		
		Tree leftOperand2 = rightOperand.getLeftOperand();
		Tree rightOperand3 = rightOperand.getRightOperand();
		
		assertTrue(leftOperand2 instanceof Constant);
		assertEquals(4, ((Constant) leftOperand2).getValue());
		assertTrue(rightOperand3 instanceof Variable); 
		assertEquals("Z", ((Variable) rightOperand3).getName());
	}
	
	@Test
	public void testTreeLevel3() {
		Tree leftOperand = tree.getLeftOperand();
		
		Tree leftOperand1 = leftOperand.getLeftOperand();
		Tree rightOperand2 = leftOperand.getRightOperand();
		
		Tree leftOperand2 = leftOperand1.getLeftOperand();		
		assertTrue(leftOperand2 instanceof Constant);
		assertEquals(2, ((Constant)leftOperand2).getValue());
		
		Tree rightOperand3 = leftOperand1.getRightOperand();
		assertTrue(rightOperand3 instanceof Variable);
		assertEquals("X", ((Variable) rightOperand3).getName());
		
		Tree leftOperand3 = rightOperand2.getLeftOperand();
		assertTrue(leftOperand3 instanceof Constant);
		assertEquals(3, ((Constant) leftOperand3).getValue());
		
		Tree rightOperand4 = rightOperand2.getRightOperand();
		assertTrue(rightOperand4 instanceof Variable);
		assertEquals("Y", ((Variable) rightOperand4).getName());	
	}
}
