package data;

/**
 * This class represents the Constant tree node. 
 * It has surely no sub-tree.
 * 
 * @see Operand
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Constant extends Operand {
    private int value;

    /**
     * To create a Constant node, we need to specify the constant int value.
     * 
     * @param value the constructed node
     */
    public Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * The calculation of the node is to simply return the constant value.
     */
    public int calculate() {
        return getValue();
    }

}
