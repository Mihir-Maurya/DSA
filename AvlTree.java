package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

import DataStructure.BinarySearchTree.Node;

public class AvlTree {
	 class Node{
	    	int data,height;
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
	    //LL condition (right rotation)
	    public Node rightRotation(Node current) {
	    	Node newRoot = current.left;
	    	current.left = current.left.right;
	    	 newRoot.right = current;
	    	 current.height = calculateHeight(current);
	    	 newRoot.height = calculateHeight(newRoot);
	    	 
	    	 return newRoot;
	    }
	    //RR condition (Left rotation)
	    public Node leftRotation(Node current) {
	    	Node newRoot = current.right;
	    	current.right =  current.right.left;
	    	newRoot.left = current;
	    	current.height = calculateHeight(current);
	    	newRoot.height = calculateHeight(newRoot);
	    	return newRoot;
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
	    	
	    	else if(root.data>=value) {
	    		root.left = insert(root.left,value);
	    		
	    	}
	    	else {
	    		root.right = insert(root.right,value);
	    		
	    	}
	    	int balance = checkBalance(root.left,root.right);
	    	if(balance > 1) {//left is overloaded
	    		if(checkBalance(root.left.left,root.left.right)>0) {//LL condition
	    			root = rightRotation(root);
	    		}else { // LR condition
	    			root.left = leftRotation(root.left);
	    			root = rightRotation(root);
	    		}
	    	}
	    	else if(balance<-1) {//right is overloaded (RR , RL)
	    		if(checkBalance(root.right.left,root.right.right)>0)
	    			root = leftRotation(root);
	    		else {
	    			root.right = rightRotation(root.right);
	    			root = leftRotation(root);
	    		}
	    	}
	    	if(root.left != null)
	    		root.left.height = calculateHeight(root.left);
	    	if(root.right != null)
	    		root.right.height = calculateHeight(root.right);
	    	root.height = calculateHeight(root);
	    	return root;
	    }
	    public int checkBalance(Node leftNode , Node rightNode) {
	    	if(leftNode == null && leftNode == null) {
	    		return 0;
	    	}
	    	else if(leftNode == null ) {
	    		return -1 - rightNode.height;
	    	}
	    	else if(rightNode == null) {
	    		return leftNode.height + 1;
	    	}
	    	
	    	else
	    		return leftNode.height - rightNode.height;
	    }
	    //calculate height
	 public  int calculateHeight(Node root) {
//	    	if(root==null)
//	    		return 0;
//	    	return 1+Math.max(root.left != null ? root.left.height:-1, root.right != null ? root.right.height:-1);
	    	 if(root==null) return -1;
	          int lheight = calculateHeight(root.left);
	          int rheight = calculateHeight(root.right);
	          if(lheight > rheight) return (lheight+1);
	          else return (rheight+1);  
	 }
	    //deletion 
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
	    		return root;
	    	}
	    	int balance = checkBalance(root.left,root.right);
	    	if(balance > 1) {//left is overloaded
	    		if(checkBalance(root.left.left,root.left.right)>0) {//LL condition
	    			root = rightRotation(root);
	    		}else { // LR condition
	    			root.left = leftRotation(root.left);
	    			root = rightRotation(root);
	    		}
	    	}
	    	else if(balance<-1) {//right is overloaded (RR , RL)
	    		if(checkBalance(root.right.left,root.right.right)>0)
	    			root = leftRotation(root);
	    		else {
	    			root.right = leftRotation(root.right);
	    			root = leftRotation(root);
	    		}
	    	}
	    	if(root.left != null)
	    		root.left.height = calculateHeight(root.left);
	    	if(root.right != null)
	    		root.right.height = calculateHeight(root.right);
	    	root.height = calculateHeight(root);
	    	return root;
	    
	    	
	    }
	    //get minimum value from BST
	    public Node  getMinimum(Node root) {
	    	if(root==null) {
	    		System.out.println("tree is empty");
	    			return null;
	    	}
	    	if(root.left == null) {
	    		return root;
	    	}
	    	return getMinimum(root.left);
	    }
 //delete avl tree
	    public Node deleteTree(Node root) {
	    	root = null;
	    	return root;
	    }
	public static void main(String[] args) {
		AvlTree avl = new AvlTree();
		avl.root = avl.insert(avl.root, 40);
		avl.root = avl.insert(avl.root, 35);
		avl.root = avl.insert(avl.root, 70);
		avl.root = avl.insert(avl.root, 50);
		avl.root = avl.insert(avl.root, 45);
		avl.root = avl.insert(avl.root, 60);
//		avl.root = avl.deletion(avl.root, 45);
		avl.levelOrderTravelsal();
//        avl.inOrder(avl.root);
		avl.root = avl.getMinimum(avl.root);
//		avl.root = avl.deleteTree(avl.root);
//		System.out.println(avl.getMinimum(avl.root));
		System.out.println();
		avl.levelOrderTravelsal();
	}

}
