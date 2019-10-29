import java.util.*;

public class BinaryTree {
	private Node root;

	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int newData) {
			left = null;
			right = null;
			data = newData;
		}
	}

	/**
	   Create an empty binary tree -- a null root pointer.
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	   Returns true if the given target is in the binary tree.
	   Uses a recursive helper.
	 */
	public boolean lookup(int data) {
		return(lookup(root, data));
	}


	/**
	   Recursive lookup  -- given a node, recur
	   down searching for the given data.
	 */
	private boolean lookup(Node node, int data) {
		if (node==null) {
			return(false);
		}

		if (data==node.data) {
			return(true);
		}
		else if (data<node.data) {
			return(lookup(node.left, data));
		}
		else {
			return(lookup(node.right, data));
		}
	}

	/**
	   Inserts the given data into the binary tree.
	   Uses a recursive helper.
	 */
	public void insert(int data) {
		root = insert(root, data);
	}


	/**
	   Recursive insert -- given a node pointer, recur down and
	   insert the given data into the tree. Returns the new
	   node pointer (the standard way to communicate
	   a changed pointer back to the caller).
	 */
	private Node insert(Node node, int data) {
		if (node==null) {
			node = new Node(data);
		}
		else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			}
			else {
				node.right = insert(node.right, data);
			}
		}
		return(node); // in any case, return the new pointer to the caller
	}

	/**
	  Prints the node values in the "inorder" order.
	  Uses a recursive helper to do the traversal.
	 */
	public void printTree() {
		printTree(root);
		System.out.println();
	}
	private void printTree(Node node) {
		if (node == null) return;

		// left, node itself, right
		printTree(node.left);
		System.out.print(node.data + "  ");
		printTree(node.right);
	}
	
	/************ ------- MAIN ----------- *********/
	
	public static void main(String[] args) {
		
		int N = 10;
		Random random = new Random();
		BinaryTree bst = new BinaryTree();
		for (int i=0; i<N; i++) {
			int randomInteger = random.nextInt(100);
			bst.insert(randomInteger);
		}
		
		bst.printTree();
		
		//bst.printTreeLevelOrder();
	}
}
