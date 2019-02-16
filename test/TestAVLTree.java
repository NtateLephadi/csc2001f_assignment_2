import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;

public class TestAVLTree
{
	AVLTree<String> avlTree = new AVLTree<String>();
	BinaryTreeNode<String> node1 = new BinaryTreeNode<String>("d", "drink", null, null, 0);
	BinaryTreeNode<String> node2 = new BinaryTreeNode<String>("b", "banana", null, null, 0);
	BinaryTreeNode<String> node3 = new BinaryTreeNode<String>("f", "fruit", null, null, 0);
	BinaryTreeNode<String> node4 = new BinaryTreeNode<String>("a", "apple", null, null, 0);
	BinaryTreeNode<String> node5 = new BinaryTreeNode<String>("c", "carrot", null, null, 0);
	BinaryTreeNode<String> node6 = new BinaryTreeNode<String>("e", "eel", null, null, 0);
	BinaryTreeNode<String> node7 = new BinaryTreeNode<String>("g", "guava", null, null, 0);

	public void TestAVLTree()
	{
		avlTree.insert(node1.data1, node1.data2);
		avlTree.insert(node2.data1, node2.data2);
		avlTree.insert(node3.data1, node3.data2, node1, 0);
		avlTree.insert(node4.data1, node4.data2, node1, 0);
		avlTree.insert(node5.data1, node5.data2, node1, 0);
		avlTree.insert(node6.data1, node6.data2, node1, 0);
		avlTree.insert(node7.data1, node7.data2, node1, 0);
	}
	
	@Test
	public void testHeight()
	{
		Assert.assertEquals(avlTree.height(null), -1);
	}

	@Test
	public void testDelete()
	{
		Assert.assertEquals(avlTree.delete("a", null), null);
		Assert.assertEquals(avlTree.delete("f", node1).data1, node1.data1);
	}

	@Test
	public void makeTreeEmpty()
	{
		avlTree.delete("a");
		avlTree.delete("b");
		avlTree.delete("c");
		avlTree.delete("d");
		avlTree.delete("e");
		avlTree.delete("f");
		avlTree.delete("g");
	}

	@Test
	public void testTreeOrder()
	{

		avlTree.treeOrder();
		avlTree.treeOrder(node1, 3);
	}
}