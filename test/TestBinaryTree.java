import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestBinaryTree
{
	
	BinaryTree<String> binaryTree = new BinaryTree<String>();
	BinaryTreeNode<String> left = new BinaryTreeNode<String>("a", "apple", null, null, 0);
	BinaryTreeNode<String> right = new BinaryTreeNode<String>("c", "carrot", null, null, 0);
	BinaryTreeNode<String> binaryTreeNode = new BinaryTreeNode<String>("b", "banana", left, right, 1);

	@Test
	public void testGetHeight()
	{
		Assert.assertEquals(-1, binaryTree.getHeight());
	}

	@Test
	public void testGetHeight1()
	{
		Assert.assertEquals(1, binaryTree.getHeight(binaryTreeNode));
	}

	@Test
	public void testGetSize()
	{
		Assert.assertEquals(0, binaryTree.getSize());
	}

	@Test
	public void testGetSize1()
	{
		Assert.assertEquals(3, binaryTree.getSize(binaryTreeNode));
		binaryTree.visit(binaryTreeNode);
		binaryTree.inOrder();
		binaryTree.inOrder(binaryTreeNode);
	}
}