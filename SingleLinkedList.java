package DataStructure;

public class SingleLinkedList {
 
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	Node head;
	//insert At front
	public void insertAtFront(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	//insert at end
	public void insertAtEnd(int data) {
		Node node = new Node(data);
		Node temp = head;
		//if head is null
		if(head==null) {
			head=node;
			return;
		}
		
		//when we have some elements in the linkedlist
			while(temp.next != null) {
			temp = temp.next;
		}
		temp.next =node;
	}
	//insert after a node's value
	public void insertAfterNode(int data, int afterValue) {
		Node node = new Node(data);
		//if list is empty
		if(head==null) {
//			head=node;
			System.out.println("List is Empty.");
			return;
		}
		//if list has some elements
		Node prev = head;
		Node curr = head.next;
		while(prev.data != afterValue)
			{
			prev = curr;
			curr = curr.next;
			}
		
		prev.next = node;
		node.next = curr;
			}
	//delete At front
	public void deleteAtFront() {
		if(head==null) {
			System.out.println("List is Empty.");
			return;
		}
		head = head.next;
	}
	//delete At End
	public void deleteAtEnd() {
		if(head==null) {
			System.out.println("List is Empty.");
			return;
		}
		if(head.next ==null) {
			head=null;
			return;
		}
		Node temp = head;
		while(temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
	}
	//delete after a node
	public void deleteAfterNode(int node) {
		if(head==null) {
			System.out.println("List is Empty.");
		}
		if(head.data==node) {
			head=null;
			return;
		}
		Node prev = null;
		Node curr = head;
		while(curr.data != node) {
			prev = curr;
			curr = curr.next;
		}
		curr.next = curr.next.next;
	}
	//serching a value
	public void serch(int value) {
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		Node temp = head;
		while(temp != null) {
			if(temp.data==value) {
				System.out.println("Value is found");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Value is not found");
	}
	//printing the list
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		
SingleLinkedList sl = new SingleLinkedList();
sl.insertAtEnd(1);
sl.insertAtEnd(2);
sl.insertAtEnd(3);
sl.insertAtEnd(4);
//sl.insertAfterNode(5, 1);
//sl.deleteAtEnd();
//sl.deleteAtFront();
sl.deleteAfterNode(2);
sl.serch(4);
sl.print();
	}

}
