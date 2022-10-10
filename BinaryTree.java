package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

 
public class BinaryTree {
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
    //preOrder traversal
    public void inOrder(Node root) {
    	if(root==null)
    		return;
    	
    	inOrder(root.left);
    	System.out.print(root.data + " ");
    	inOrder(root.right);
    	
    }
    //preOrder traversal
    public void postOrder(Node root) {
    	if(root==null)
    		return;
    	
    	postOrder(root.left);
    	postOrder(root.right);
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
    //serching
    public void serching(int value) {
    	if(root==null) {
    		System.out.println("Tree is Empty.");
    		return;
    	}
    	Queue<Node> q = new LinkedList<>();
    	q.add(root);
    	while(!q.isEmpty()) {
    		Node temp = q.remove();
    		if(temp.data == value) {
    			System.out.println("Value found");
    			return;
    		}
//    		System.out.println(temp.data + " ");
    		if(temp.left != null)
    			q.add(temp.left);
    		if(temp.right != null)
    			q.add(temp.right);
    	}
    	System.out.println("Value not found");
    }
    // insertion
    public void  insertion(int data) {
    	Node node = new Node(data);
    	if(root==null) {
    		root=node;
    		return;
    	}
    	Queue<Node> q = new LinkedList<>();
    	q.add(root);
    	while(!q.isEmpty()) {
    		Node temp = q.remove();
//    		if(temp.data == value) {
//    			System.out.println("Value found");
//    			return;
//    		}
//    		System.out.println(temp.data + " ");
    		if(temp.left == null) {
    			temp.left = node;
    			return;
    		}
    			
    		if(temp.right == null) {
    			temp.right = node;
    			return;
    		}
    		else {
    			
        		q.add(temp.left);
        		q.add(temp.right);
    		}
    	}
    	
    }
    
    //deletion in tree
    public void deletion(int value) {
    	if(root==null) {
    		System.out.println("Tree is Empty.");
    		return;
    	}
    	Queue<Node> q = new LinkedList<>();
    	q.add(root);
    	while(!q.isEmpty()) {
    		Node temp = q.remove();
    		 //if node is found then copy data of deepest node here and delete the deepest node
    		if(temp.data == value) {
    			temp.data = deleteDeepestNode();
    			return;
    		}
//    		System.out.println(temp.data + " ");
    		if(temp.left != null)
    			q.add(temp.left);
    		if(temp.right != null)
    			q.add(temp.right);
    	}
    	System.out.println("Value not found");
    }
    
//private int deleteDeepestNode() {
//	if(root==null) {
//		System.out.println("Tree is Empty");
//		return -1;
//	}
//	int result = 0;
//	Queue<Node> q = new LinkedList<>();
//	q.add(root);
//	Node prev,curr=null;
//	while(!q.isEmpty()) {
//		prev=curr;
//		curr=q.remove();
//		if(curr.left == null) {
//			result = prev.right.data;
//			prev.right=null;
//			return result;
//		}
//		if(curr.right == null) {
//			result = curr.left.data;
//			curr.left = null;
//			return result;
//		}else {
//			q.add(curr.left);
//			q.add(curr.right);
//		}
//	}
//	return -1;
//	}
    //this method is going to return and delete the deepestNode
	private int deleteDeepestNode() {
		if(root==null) {
			System.out.println("tree is Empty. ");
			return -1; 
		}
		Queue<Node> q = new LinkedList<>();
    	q.add(root);
    	
    	int result =  0;
		Node previous,current = null; 
    	while(!q.isEmpty()) {
    		previous = current;
    		current = q.remove();
    		
//    		System.out.println(temp.data + " ");
    		
    		
    		if(current.left == null) {
    			result = previous.right.data;
    			previous.right = null;  
    			return result;
    		}
    		
    		if(current.right == null) {
    			result = current.left.data;
    			current.left = null;
    			return result;
    		}
    		
    		else {
    			q.add(current.left);
    			q.add(current.right);
    		}
    		
    	}
    	
		return -1;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insertion(1);
		bt.insertion(2);
		bt.insertion(3);
		bt.insertion(4);
		bt.insertion(5);
		bt.deletion(1);
	    bt.levelOrderTravelsal();
	    System.out.println();
//	    bt.preOrder(bt.root);
	}

}
