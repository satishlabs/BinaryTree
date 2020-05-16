package com.bt;
/*
 *Check for Symmetric Binary Tree
 Input :   
    
     1
   /   \
  2     2
 / \   / \
3   4 4   3

Output : Symmetric
 */


public class CheckIsBTSymmetric {
	static Node root;
	static class Node{
		int data;
		Node left,right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String[] args) {
		CheckIsBTSymmetric tree = new CheckIsBTSymmetric();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(2);
		
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(3);
		
		boolean output = tree.isSymmetric(tree.root);
		if(output == true) {
			System.out.println("Binary Subtree is Symetric");
		}else {
			System.out.println("Binary Subtree is not Symetric");
		}
		
	}

	public boolean isSymmetric(Node root) {
		// check if tree is mirror of itself 
		return isMirror(root, root);
	}
	 // returns true if trees with roots as root1 and root2 are mirror 
	public boolean isMirror(Node node1, Node node2) {
		
		// if both trees are empty, then they are mirror image 
		if(node1 == null && node2 == null)
			return true;
		
		// For two trees to be mirror images, the following three 
        // conditions must be true 
        // 1 - Their root node's key must be same 
        // 2 - left subtree of left tree and right subtree 
        //      of right tree have to be mirror images 
        // 3 - right subtree of left tree and left subtree 
        //      of right tree have to be mirror images
		
		if(node1 != null && node2 != null && node1.data == node2.data)
			return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
		
		// if neither of the above conditions is true then 
        // root1 and root2 are mirror images 
		return false;
	}
}
