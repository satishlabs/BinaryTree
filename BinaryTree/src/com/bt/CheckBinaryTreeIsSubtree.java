package com.bt;
//Check if a binary tree is subtree of another binary tree 
public class CheckBinaryTreeIsSubtree {
	static Node root1,root2; 
	static class Node{
		int data;
		Node left,right,nextRight;
		Node(int item)  
		{ 
			data = item; 
			left = right = nextRight = null; 
		}
	}

	public static void main(String[] args) {
		CheckBinaryTreeIsSubtree tree = new CheckBinaryTreeIsSubtree();
		// TREE 1 
		/* Construct the following tree 
              1 
             /   \ 
            2     3 
           /    \     \ 
          4      5      6 
           \ 
            7  */

		tree.root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		root1.right.right = new Node(6);
		root1.left.left.right = new Node(7);

		// TREE 2 
		/* Construct the following tree 
           2 
         /    \ 
         4      5 
          \ 
          7  */

		tree.root2 = new Node(2);
		root2.left = new Node(4);
		root2.right = new Node(5);
		root2.left.right = new Node(7);

		if(tree.isSubtree(tree.root1, tree.root2)) {
			System.out.println("Tree2 is subtree of Tree 1");
		}else {
			System.out.println("Tree2 is not a subtree of Tree 1");
		}
	}

	public boolean isSubtree(Node T, Node S) {

		//base cases
		if(S == null)
			return true;

		if(T == null)
			return false;
		/* Check the tree with root as current node */
		if(areIdentical(T, S))
			return true;

		return isSubtree(T.left, S) || isSubtree(T.right, S);
	}

	public boolean areIdentical(Node root1, Node root2) {
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null || root2 == null )
			return false;
		/* Check if the data of both roots is same and data of left and right 
        subtrees are also same */
		return (root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
	}
}
