package DataStructure;

import java.util.Scanner;

public class MaxHeap {
     private int[] arr;
     private int size ;
     
     //constructor for creating empty Min Heap
     public MaxHeap(int capacity) {
    	  //we are adding one here so that the first cell of the array can be left blank all the time
    	 
    	      arr = new int[capacity+1];
    	      size = 0;
     }
     //peek the head of the heap
     public int peek() {
    	 if(size==0) {
    		 System.out.println("heap is empty.");
    		 return -1;
    	 }
    	 return arr[1];
     }
     //return size
     public int getSize() {
    	 return size;
     }
     //level order traversal
     public void levelOrder() {
    	 for(int i = 1; i<=size;i++) {
    		 System.out.print(arr[i]  + " ");
    	 }
     }
     //inserting a value in hap
     public void insert(int value) {
    	 if(size==arr.length-1) {
    		 System.out.println("heap is full");
    		 return;
    	 }
    	 arr[size+1] = value;
    	 size++;
    	 heapifyBottomToTop(size);
     }
	private void heapifyBottomToTop(int index) {
	  int parent = index/2;//formula to get parent index of  particular cell
	  // we are at root of the heap, hence no more heapifying is required
	  if(index<=1)
		  return;
	  //if current value is greater than its parent, then we need to swap
	  if(arr[index]>arr[parent]) {
		  int temp = arr[index];
		  arr[index] = arr[parent];
		  arr[parent] = temp;
	  }
	  
	  heapifyBottomToTop(parent);
	}
	//Extract Heap of Heap
	public int extractMaximum() {
		if(size==0) {
			System.out.println("heap is empty");
			return -1;
		}
		int extractedValue = arr[1];
		arr[1] = arr[size];
		size--;
		heapifyTopToBottom(1);
		return extractedValue;
	}
	private void heapifyTopToBottom(int index) {
		int left = index*2;
		int right = (index*2) + 1;
		int greatestValue;
		if(size<left) //no child
			return;
		else if(size==left) {//one child
			if(arr[index] > arr[left]) {
				int temp = arr[index];
				arr[index] = arr[left];
				arr[left] = temp;
			}
			return;
		}
		else {
			//having two child
			if(arr[left] > arr[right])
				greatestValue = left;
			else
				greatestValue = right;
			//if parent is lesser value than graetest child, we have to swap
			if(arr[index] < arr[greatestValue]) {
				int temp = arr[index];
				arr[index] = arr[greatestValue];
				arr[greatestValue] = temp;
			}
		}
		heapifyTopToBottom(greatestValue);
	}
	// delete heap
	public void deleteHeap() {
		arr = null;
	}
	public static void main(String[] args) {
          

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length: ");
        MaxHeap h = new MaxHeap(sc.nextInt());

        while(true)
        {
            System.out.println("\n_______________________________________");
            System.out.println("ENTER YOUR CHOICE FOR HEAP OPERATIONS");
            System.out.println("	PRESS 1 TO INSERT");
            System.out.println("	PRESS 2 TO PEEK");
            System.out.println("	PRESS 3 TO GET SIZE");
            System.out.println("	PRESS 4 FOR LEVEL ORDER TRAVERSAL");
            System.out.println("	PRESS 5 TO EXTRACT MAXIMUM");
            System.out.println("	PRESS 6 TO DELETE HEAP AND EXIT");
            System.out.println("________________________________________");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:System.out.print("Enter Element: ");
                    h.insert(sc.nextInt());
                    break;
                case 2:System.out.println("Head = "+h.peek());
                    break;
                case 3:System.out.println("Size = "+h.getSize());
                    break;
                case 4:h.levelOrder();
                    break;
                case 5:System.out.println("Extracted Minimum = "+h.extractMaximum());
                    break;
                case 6:h.deleteHeap();
                    System.exit(0);
                    break;
                default:System.out.println("Wrong Choice:");
            }
        }

	}

}
