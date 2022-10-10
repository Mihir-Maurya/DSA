package DataStructure;

import java.util.Scanner;

public class MinHeap {

	private int[] arr;
	int size;
	//constructor for creating empty Min Heap
	public MinHeap(int capacity) {
		 //we are adding one here so that the first cell of the array can be left blank all the time
		
		arr = new int[capacity+1];
		size = 0;
	}
	//peek the head of the MinHap
	public int peek() {
		if(size==0) {
			System.out.println("Heap is Empty");
			return -1;
		}
		return arr[1];
	}
	public int getSize() {
		return size;
	}
	//level order traversal
	public void levelOrder() {
		for(int i = 1; i<=size;i++) {
			System.out.print(arr[i]  + " ");
		}
	}
	//insert a new value in heap
	public void insert(int value) {
		if(size==arr.length-1) {
			System.out.println("heap is full");
			return ;
		}
		arr[size+1] = value;
		size++;
		heapifyBottomToTop(size);
	}
	private void heapifyBottomToTop(int index) {
		
		int parent = index/2;
		
		 // we are at root of the heap, hence no more heapifying is required
		if(index <=1) {
			return;
		}
		
		//if the current value is smaller than its parent , thn w need to swap
		if(arr[index] < arr[parent]) {
			int temp = arr[index];
			arr[index] = arr[parent];
			arr[parent] = temp;
		}
		heapifyBottomToTop(parent);
		
	}
	
	//Extract Head of heap
	public int extractMinimum() {
		if(size==0) {
			System.out.println("heap is Empty");
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
		int smallestChild;
		
		if(size < left) //there is no children
			return;
		else if(size==left) //if there is only left children
		{
			if(arr[index]> arr[left]) {
				int temp = arr[index];
				arr[index] = arr[left];
				arr[left] = temp;
			}
			return;
		}
		else {//if both children are present
			//finding smallest number
			if(arr[left] > arr[right]){
				smallestChild = right;
			}
			else
				smallestChild = left;
			if(arr[index] > arr[smallestChild]) {
				int temp = arr[index] ;
				arr[index] = arr[smallestChild];
				arr[smallestChild] = temp;
			}
		}
		heapifyTopToBottom(smallestChild);
		
	}
	//deleteHeap
	public void deleteHeap() {
		arr = null;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Length");
		int n = sc.nextInt();
		MinHeap h= new MinHeap(n);
	 
		  while(true)
	        {
	            System.out.println("\n_______________________________________");
	            System.out.println("ENTER YOUR CHOICE FOR HEAP OPERATIONS");
	            System.out.println("	PRESS 1 TO INSERT");
	            System.out.println("	PRESS 2 TO PEEK");
	            System.out.println("	PRESS 3 TO GET SIZE");
	            System.out.println("	PRESS 4 FOR LEVEL ORDER TRAVERSAL");
	            System.out.println("	PRESS 5 TO EXTRACT MINIMUM");
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
	                case 5:System.out.println("Extracted Minimum = "+h.extractMinimum());
	                    break;
	                case 6:h.deleteHeap();
	                    System.exit(0);
	                    break;
	                default:System.out.println("Wrong Choice:");
	            }
	        }
	}

}
