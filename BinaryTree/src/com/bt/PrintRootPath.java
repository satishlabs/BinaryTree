package com.bt;

import java.util.ArrayList;

/*
 * Print path from root to a given node in a binary tree
 Input :          1
               /   \
              2     3
             / \   /  \
            4   5  6   7

               x = 5

Output : 1->2->5
 * */

public class PrintRootPath {
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
		int x = 5;
		printPath(root, x);
	}
	public static void printPath(Node root, int x) {
		//ArrayList to store the path
		ArrayList<Integer> arr = new ArrayList<>();
		
		if(hasPath(root, arr, x)) {
			for(int i=0;i<arr.size()-1;i++) 
				System.out.print(arr.get(i)+" -> ");
				System.out.println(arr.get(arr.size()-1));
			
		}else {
			System.out.println("No Path");
		}
	}
	public static boolean hasPath(Node root, ArrayList<Integer> arr, int x) {
		//if root is NULL
		if(root == null)
			return false;
		
		//push the node's value in arr
		arr.add(root.data);
		
		//If it is required node return true
		if(root.data == x)
			return true;
		
		if(hasPath(root.left, arr, x) || hasPath(root.right, arr, x))
			return true;
		
		arr.remove(arr.size()-1);
		return false;
	}
}
