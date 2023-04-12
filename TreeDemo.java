/**
 * TreeDemo with helper methods.
 * <p>
 * 
 * @author Spencer Hooper
 *
 */

class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /**
	 * A recursive method to insert nodes into a BST
    * @param Node root, int value
    * @return Node
	 */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
       
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
    /**
	 * An iterative method to insert nodes into a BST
    * @param int value
    * 
	 */
   public void insert(int value){
      //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;
         
         while(true){
            parent = current;
            
            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }
           
         }//closing while
      
      }//closing main if-else 
   }  
   
   /**
	 * preOrderTraversal 
    * @param Node root
	 */
   public void preOrderTraversal(Node root){
   if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);   
   }

   
   
   /**
	 * inOrderTraversal 
    * @param Node root
	 */
   public void inOrderTraversal(Node root){
   if (root == null)
            return;
 
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
   }
   
   
   
   /**
	 * postOrderTraversal 
    * @param Node root
	 */
   public void postOrderTraversal(Node root){
         if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
   }
   
   
   
   /**
	 * A method to find a specific key in a BST 
    * @param Node root, int key
    * @return boolean
	 */
   public boolean find(Node root, int key){
	if (root == null) {
        return false;
    }
    if (root.value == key) {
        return true;
    }
    return find(root.left, key) || find(root.right, key);           
   }
   
   
   
   /**
	 * A method to find the min key in a BST 
    * @param Node root
    * @return int
	 */
   public int getMin(Node root){
   if (root == null) {
        return Integer.MIN_VALUE; // or throw an exception to indicate an empty tree
    } else if (root.left == null) {
        return root.value;
    } else {
        return getMin(root.left);
      }   
    }
  
  
  
   /**
	 * A method to find the max key in a BST 
    * @param Node root
    * @return int
	 */

   public int getMax(Node root){
	if (root == null) {
       return 0;    }
    Node current = root;
    while (current.right != null) {
        // Traverse to the rightmost node, which contains the largest value
        current = current.right;
    }
    return current.value;
   }
   
   
   
  /**
	 * A method to delete a key in a BST
    * @param Node root, int key
    * @return Node
	 */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}