import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({TestBinaryTreeNode.class, TestBinaryTree.class, TestBinarySearchTree.class, TestAVLTree.class, TestSearchAVL.class, TestSearchIt.class, TestPrintIt.class})

public class TestSuite 
{
	TestSuite testSuite = new TestSuite();    
}  	