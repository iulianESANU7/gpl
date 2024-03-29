package test.unit;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 * This is the global test suite of unit tests.
 * 
 * It includes two test cases : {@link TestTreeBuild} and {@link TestTreeVisitor}.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestTreeBuild.class, TestTreeVisitor.class})
public class TreeTestSuite {

}
