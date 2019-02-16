import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestBinaryTreeNode
{
	BinaryTreeNode<String> left = new BinaryTreeNode<String>("a", "apple", null, null, 0);
	BinaryTreeNode<String> right = new BinaryTreeNode<String>("c", "carrot", null, null, 0);
	BinaryTreeNode<String> binaryTreeNode = new BinaryTreeNode<String>("b", "banana", left, right, 1);

	@Before
	public void setUp()
	{
	}

	@Test
	public void testGetLeft()
	{
		Assert.assertEquals(left, binaryTreeNode.getLeft());
	}

	@Test
	public void testGetRight()
	{
		Assert.assertEquals(right, binaryTreeNode.getRight());
	}
}