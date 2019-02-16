import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;

public class TestBinarySearchTree
{
	BinarySearchTree<String> binarySearchTree = new BinarySearchTree<String>();
	BinaryTreeNode<String> node1 = new BinaryTreeNode<String>("d", "drink", null, null, 0);
	BinaryTreeNode<String> node2 = new BinaryTreeNode<String>("b", "banana", null, null, 0);
	BinaryTreeNode<String> node3 = new BinaryTreeNode<String>("f", "fruit", null, null, 0);
	BinaryTreeNode<String> node4 = new BinaryTreeNode<String>("a", "apple", null, null, 0);
	BinaryTreeNode<String> node5 = new BinaryTreeNode<String>("c", "carrot", null, null, 0);
	BinaryTreeNode<String> node6 = new BinaryTreeNode<String>("e", "eel", null, null, 0);
	BinaryTreeNode<String> node7 = new BinaryTreeNode<String>("g", "guava", null, null, 0);

	public TestBinarySearchTree()
	{
		binarySearchTree.insert(node1.data1, node1.data2);
		binarySearchTree.insert(node2.data1, node2.data2);
		binarySearchTree.insert(node3.data1, node3.data2, node1);
		binarySearchTree.insert(node4.data1, node4.data2, node1);
		binarySearchTree.insert(node5.data1, node5.data2, node1);
		binarySearchTree.insert(node6.data1, node6.data2, node1);
		binarySearchTree.insert(node7.data1, node7.data2, node1);
	}

	public void makeTreeEmpty()
	{
		binarySearchTree.delete("a");
		binarySearchTree.delete("b");
		binarySearchTree.delete("c");
		binarySearchTree.delete("d");
		binarySearchTree.delete("e");
		binarySearchTree.delete("f");
		binarySearchTree.delete("g");
	}

	@Test
	public void testFind()
	{
		Assert.assertEquals(binarySearchTree.find("a"), null);
		Assert.assertEquals(binarySearchTree.find("a", node1).data1, node4.data1);
		Assert.assertEquals(binarySearchTree.find("g", node1).data1, node7.data1);
		Assert.assertEquals(binarySearchTree.find("z", node1), null);
	} 

	@Test
	public void testTreeOrder()
	{
		binarySearchTree.treeOrder();
		binarySearchTree.treeOrder(node1, 3);
	}
	
	@Test
	public void testDelete()
	{
		Assert.assertEquals(binarySearchTree.delete("a", null), null);
		Assert.assertEquals(binarySearchTree.delete("f", node1).data1, node1.data1);
	}

	@Test
	public void testEmptyTreeFind()
	{
		makeTreeEmpty();
		Assert.assertEquals(binarySearchTree.find("d"), null);
	}

	@Test
	public void testFindMin()
	{
		Assert.assertEquals(binarySearchTree.findMin(node1).data1, node4.data1);
	}

	@Test
	public void testRemoveMin()
	{
		Assert.assertEquals(binarySearchTree.removeMin(null), null);
		Assert.assertEquals(binarySearchTree.removeMin(node2), null);
		Assert.assertEquals(binarySearchTree.removeMin(node1).data1, node1.data1);
	}
}
