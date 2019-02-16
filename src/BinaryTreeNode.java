/**
   BinaryTreeNode is a node for binary trees, it contains 2 objects data1 and data2

   @author Tumelo Lephadi
   @version 10 April 2017
*/
public class BinaryTreeNode<dataType>
{
   dataType data1;
   dataType data2;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;   
   /**
      @param d1 data in the node
      @param d2 data in the node
      @param l the left child of the node
      @param r the right child of the node
      @param h the height of the node
   */
   public BinaryTreeNode (dataType d1, dataType d2, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r, int h)
   {
      data1 = d1;
      data2 = d2; 
      left = l;
      right = r;
      height = h;
   }
   
   /**
      @return returns the left child of the node
   */
   BinaryTreeNode<dataType> getLeft () 
   {
	  return left;
   }
   
   /**
      @return returns the right child of the node
   */
   BinaryTreeNode<dataType> getRight () 
   { 
      return right; 
   }
}
