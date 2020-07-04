package com.bt;

import com.bt.PrintRootPath.Node;

public class MaxNodeInBTree {
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
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		//int x = 5;
		System.out.println(maxNode(root));
	}
	private static int maxNode(Node root) {
		int maxValue = Integer.MIN_VALUE;
		if(root != null) {
			int leftMax = maxNode(root.left);
			int rightMax = maxNode(root.right);
			
			if(leftMax > rightMax) {
				maxValue = leftMax;
			}else {
				maxValue = rightMax;
			}
			if(root.data > maxValue) {
				maxValue = root.data;
			}
		}
		return maxValue;
	}
}
