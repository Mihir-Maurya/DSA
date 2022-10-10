package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

import DataStructure.BinaryTree.Node;

public class BinarySearchTree {
	 class Node{
	    	int data;
	    	Node left,right;
	    	Node(int data){
	    		this.data = data;
	    		left=right=null;
	    	}
	    }
	  public  Node root;
	    //DFS preOrder(root,L,R),inOrder(L,root,R) and postOrder(l,R,root)
	    // DFS traversal
	    
	    //preOrder traversal
	    public void preOrder(Node root) {
	    	if(root==null)
	    		return;
	    	System.out.print(root.data + " ");
	    	preOrder(root.left);
	    	preOrder(root.right);
	    	
	    }
	    //inOrder traversal   Ascending order
	    public void inOrder(Node root) {
	    	if(root==null)
	    		return;
	    	
	    	preOrder(root.left);
	    	System.out.print(root.data + " ");
	    	preOrder(root.right);
	    	
	    }
	    //reverse order
	    public void reverseOrder(Node root) {
	    	if(root==null)
	    		return;
	    	reverseOrder(root.right);
	    	System.out.print(root.data + " ");
	    	reverseOrder(root.left);
	    }
	    //preOrder traversal
	    public void postOrder(Node root) {
	    	if(root==null)
	    		return;
	    	
	    	preOrder(root.left);
	    	preOrder(root.right);
	    	System.out.println(root.data + " ");
	    }
	    //BFS traversal Level order traversal
	    public void levelOrderTravelsal() {
	    	if(root==null) {
	    		System.out.println("Tree is Empty.");
	    		return;
	    	}
	    	Queue<Node> q = new LinkedList<>();
	    	q.add(root);
	    	while(!q.isEmpty()) {
	    		Node temp = q.remove();
	    		System.out.print(temp.data + " ");
	    		if(temp.left != null)
	    			q.add(temp.left);
	    		if(temp.right != null)
	    			q.add(temp.right);
	    	}
	    }
	    //serching in BST
	    public void serch(Node root, int value) {
	    	if(root==null) {
	    		System.out.println("Value not found");
	    		return;
	    	}
	    	if(root.data == value) {
	    		System.out.println("Value is Found");
	    		return;
	    	}
	    	else if(root.data>value) {
	    		serch(root.left,value);
	    		return;
	    	}
	    	else {
	    		serch(root.right,value);
	    		return;
	    	}
	    }

	    //inserting value in BST
	    public Node insert(Node root, int value) {
	    	Node node = new Node(value);
	    	if(root==null) {
	    		root = node;
	    		return root;
	    	}
	    	
	    	else if(root.data>value) {
	    		root.left = insert(root.left,value);
	    		
	    	}
	    	else {
	    		root.right = insert(root.right,value);
	    	}
//	    	System.out.println(root.data);
	    	return root;
	    	
	    }
//	    //deletion 
	    public Node deletion(Node root, int value) {
	    	if(root==null) {
	    		System.out.println("Value not found.");
	    		return null;
	    	}
	    
	    	else if(root.data > value) {
	    		root.left = deletion(root.left, value);
	    	}
	    	else if(root.data<value) {
	    		root.right = deletion(root.right, value);
	    	}
	    	else {
	    		//if node has a two children
	    		if(root.left != null && root.right != null) {
	    			Node temp = root;
	    			Node minimumFromRight = getMinimum(temp.right);
	    			root.data = minimumFromRight.data;
	    			root.right = deletion(root.right,minimumFromRight.data);
	    		}
	    		//if node has left child
	    		else if(root.left != null) {
	    			root = root.left;
	    		}
	    	 // if node has right child
	    		else if(root.right != null) {
	    			root = root.right;
	    		}
	    		// if node is leaf
	    		else {
	    			root = null;
	    		}
	    	}
	    	
	    	return root;
	    }
//	    get minimum value from BST
	    public Node  getMinimum(Node root) {
	    	if(root==null) {
	    		System.out.println("tree is empty");
	    			return null;
	    	}
	    	if(root.left == null) {
	    		return root;
	    	}else 
	    	return getMinimum(root.left);
	    }
	    
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.insert(bst.root,1);
		bst.root = bst.insert(bst.root,2);
		bst.root = bst.insert(bst.root,3);
		bst.root = bst.insert(bst.root,4);
		bst.root = bst.insert(bst.root,5);
		bst.root = bst.insert(bst.root,6);
		System.out.println("Level order traversal");
		bst.levelOrderTravelsal();
		System.out.println();
		System.out.println("inOrder traversal.");
		bst.inOrder(bst.root);
		System.out.println();
		System.out.println("reverse order traversal.");
		bst.reverseOrder(bst.root);
		System.out.println();
//		bst.root = bst.deletion(bst.root, 6);
		System.out.println("tree after deletion.");
//		bst.inOrder(bst.root);
//		System.out.println();
//		bst.root = bst.getMinimum(bst.root);
//		System.out.println();
		bst.levelOrderTravelsal();

	}

}
