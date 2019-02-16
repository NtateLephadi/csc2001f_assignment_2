/**
   BinaryTree is a data structure that holds nodes

   @author Tumelo Lephadi
   @version 10 April 2017
*/

public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;

   public BinaryTree ()
   {
      root = null;
   }

   /**
      @return returns the height of the tree
   */
   public int getHeight ()
   {
      return getHeight (root);
   }

   /**
      @param node node which we measure the height from
      @return returns the height of the node
   */
   public int getHeight (BinaryTreeNode<dataType> node)
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   /**
      @return returns the size of the tree
   */
   public int getSize ()
   {
      return getSize (root);
   }

   /**
      @param node node that has size checked
      @return returns the number of nodes in the tree
   */
   public int getSize (BinaryTreeNode<dataType> node)
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }

   /**
      prints to the screen one of the data
      @param node a node that is printed
   */
   public void visit (BinaryTreeNode<dataType> node)
   {
      System.out.println (node.data1);
   }

   //prints the screen the in order tree
   public void inOrder ()
   {
      inOrder (root);
   }

   /**
      prints to screen the sorted tree
      @param node node that printing is starting from
   */
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }
   }
}
