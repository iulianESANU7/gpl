package data;

import gui.management.PaintVisitor;

/**
 * 
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public interface Tree {
    Tree getLeftOperand();

    Tree getRightOperand();

    int calculate();

	void accept(PaintVisitor paintVisitor);
}
