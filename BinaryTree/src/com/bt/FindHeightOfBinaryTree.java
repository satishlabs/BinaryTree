package com.bt;
//Find Height of Binary Tree OR Find the Maximum Depth of Binary Tree.
public class FindHeightOfBinaryTree {
	static Node root;
	static class Node{
		int data;
		Node left,right;
		
		public Node(int data) {
			this.data = data;
			this.left=null;
			this.right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
		
		
	}
	
	public static void main(String[] args) {
		  /*
        Height = 4
        
             50
          /      \
         30       70
       /   \     /  \
      20   40   60  80
     /  \
    10  25
*/
		
		
		FindHeightOfBinaryTree tree = new FindHeightOfBinaryTree();
		tree.root = new Node(50);
		
		root.left = new Node(30);
		root.right = new Node(70);
		
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right.left = new Node(60);
		root.right.right = new Node(80);
		
		root.left.left.left = new Node(10);
		root.left.left.right = new Node(25);
		
		int height = findHeightOfTree(root);
        System.out.println(height);
		
	}

	private static int findHeightOfTree(Node root) {
		if(root  == null)
		{
			return 0;
		}
		
		int leftHeight = findHeightOfTree(root.getLeft());
		int rightHeight = findHeightOfTree(root.getRight());
		return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
	}
}
