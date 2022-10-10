package Stack;

public class StackUsingLinkedlist {
	
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			
		}
	}
	Node top;
	int size;
	 void push(int data) {
		Node node = new Node(data);
		node.next=top;
	    top=node;
	    size++;
	}
	 int pop() {
		 if(isEmpty()) {
			 System.out.println("Stack is Empty");
			 return -1;
		 }
		 int result = top.data;
		 top = top.next;
		 size--;
		 return result;
	 }
	 boolean isEmpty() {
		 return top==null;
	 }
	 int peek() {
		 return top.data;
	 }
	 int size() {
		 return size;
	 }
	 void print() {
		 Node temp = top;
		 while(temp!= null) {
			 System.out.println(temp.data );
			 temp = temp.next;
		 }
	 }
	public static void main(String[] args) {
	StackUsingLinkedlist s = new StackUsingLinkedlist();
	s.push(1);
	s.push(2);
	s.push(3);
	s.push(4);
    s.pop();
    System.out.println(s.peek());
	s.print();
	}

}
