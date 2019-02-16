/**
      BinarySearchTree is a special kind of BinaryTree which orders itself to a certain extent
      @author Tumelo Lephadi
      @version 10 April 2017
*/
public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   /**
      Inserts nodes in tree
      @param d1 data in the node
      @param d2 data in the node
   */
   public void insert (dataType d1, dataType d2)
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d1, d2, null, null, 0);
      else
         insert (d1, d2, root);
   }
   /**
      Inserts node in tree
      @param d1 data in the node
      @param d2 data in the node
      @param node new node to be added
   */
   public void insert ( dataType d1, dataType d2, BinaryTreeNode<dataType> node )
   {
      if (d1.compareTo (node.data1) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d1, d2, null, null, 0);
         else
            insert (d1, d2, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d1, d2, null, null, 0);
         else
            insert (d1, d2, node.right);
      }
   }
   /**
      @param d1 data queried in Tree
      @return returns node if query matches d1 or null
   */
   public BinaryTreeNode<dataType> find (dataType d1)
   {
      if (root == null)
         return null;
      else
         return find (d1, root);
   }
   /**
      @param d1 data queried in the Tree
      @param node node that is searched
      @return returns node if query matches d1 or null
   */
   public BinaryTreeNode<dataType> find (dataType d1, BinaryTreeNode<dataType> node)
   {
      if (d1.compareTo (node.data1) == 0)
         return node;
      else if (d1.compareTo (node.data1) < 0)
         return (node.left == null) ? null : find (d1, node.left);
      else
         return (node.right == null) ? null : find (d1, node.right);
   }
   /**
      @param d1 delete node from tree
   */
   public void delete (dataType d1)
   {
      root = delete (d1, root);
   }
   /**
      @param d1 data that is to be deleted
      @param node node to be deleted
      @return returns a new tree without the node that's deleted
   */
   public BinaryTreeNode<dataType> delete (dataType d1, BinaryTreeNode<dataType> node)
   {
      if (node == null) return null;
      if (d1.compareTo (node.data1) < 0)
         node.left = delete (d1, node.left);
      else if (d1.compareTo (node.data1) > 0)
         node.right = delete (d1, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data1 = findMin (node.right).data1;
         node.data2 = findMin (node.right).data2;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   /**
      @param node node with smallest value being searched
      @return returns the node with the smallest value
   */
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }
   /**
      @param node node with smallest value which is being deleted
      @return returns the tree without the node
   */
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }

   //prints the level that a node is at
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }

   /**
      @param node node that will have the order printed from
      @param level level that the method will stop printing from
   */
   public void treeOrder (BinaryTreeNode<dataType> node, int level)
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data1);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}
