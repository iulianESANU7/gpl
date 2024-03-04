package process.visitor;

import data.Addition;
import data.Constant;
import data.Multiplication;
import data.Subtraction;
import data.Variable;

/**
 * Generic tree visitor supporting all type type.
 * 
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public interface TreeVisitor<T> {

	T visit(Constant node);

	T visit(Variable node);

	T visit(Addition node);

	T visit(Subtraction node);

	T visit(Multiplication node);

}