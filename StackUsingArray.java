package Stack;

public class StackUsingArray {
      int top;
      int size;
      int a[];
      StackUsingArray(int size){
    	  this.size=size;
    	  a = new int[size];
    	  top=-1;
      }
      void push(int data) {
    	if(!isFull()) {  
    		 a[++top]=data;
           
    	}else {
    		System.out.println("Stack is full");
    		return;
    	}
      }
      int pop() {
    	  if(isEmpty()) {
    		  System.out.println("Stack is empty");
    		  return -1;
    	  }
    	  int ans = a[top];
    	  top--;
    
    	  return ans;
      }
      boolean isFull() {
    	 return size-1==top;
      }
      boolean isEmpty() {
    	  return top==-1;
      }
      void print() {
    	  for(int i = 0; i<a.length;i++) {
    		  System.out.println(a[i]);
    	  }
      }
	public static void main(String[] args) {
		StackUsingArray s = new StackUsingArray(5);
          s.push(5);
          s.push(4);
          s.push(3);
          s.push(2);
          s.push(1);
//          s.push(6);
	      s.print();
//	     System.out.println(s.isFull());
	}

}
