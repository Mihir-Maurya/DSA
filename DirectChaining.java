package Hashing;

import java.util.LinkedList;
import java.util.Scanner;

public class DirectChaining {
        LinkedList<String> [] hashTable;
        
        //Arrays of LinkedList references is created
        public DirectChaining(int length) {
        	hashTable = new LinkedList[length];
        }
        //hash function to be used on keys
        private int hashFunction(String s, int m) {
        	char ch[] = s.toCharArray();
        	int sum = 0;
        	for(int i = 0; i<s.length();i++) {
        		sum +=ch[i];                  
        	}
        	return sum % m;
        } 
        //insert key in hashTable
        public void insert(String value) {
        	int index = hashFunction(value,hashTable.length);
        	if(hashTable[index]==null) {
        		hashTable[index] = new LinkedList<>();
        		hashTable[index].add(value);
        	}
        	else
        	hashTable[index].add(value);
        }
        //serching a value in hash Table
        public void serch(String value) {
        	int index = hashFunction(value,hashTable.length);
        	if(hashTable[index] != null && hashTable[index].contains(value)) {
        		System.out.println("value is found at index " + index);
        	}
        	else
        		System.out.println("value not found");
        }
        //deleting a value in hash Table
        public void deleting(String value) {
        	int index = hashFunction(value,hashTable.length);
        	if(hashTable[index] != null && hashTable[index].contains(value)) {
        		hashTable[index].remove();
        	}
        	else
        		System.out.println("value not found");
        }
        //display hashTable
        public void display() {
        	for(int i = 0; i<hashTable.length;i++) {
//        		if(hashTable[i] != null)
        		System.out.println(hashTable[i]);
        	}
        }
        //delete entire hash table
        public void deleteHashTable() {
        	hashTable = null;
        }
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter length: ");
	        DirectChaining h = new DirectChaining(sc.nextInt());

	        while(true)
	        {
	            System.out.println("\n_____________________________________");
	            System.out.println("ENTER YOUR CHOICE FOR HASH OPERATIONS");
	            System.out.println("	PRESS 1 TO INSERT A KEY");
	            System.out.println("	PRESS 2 TO SEARCH A KEY");
	            System.out.println("	PRESS 3 TO DELETE A KEY");
	            System.out.println("	PRESS 4 TO DISPLAY HASH TABLE");
	            System.out.println("	PRESS 5 TO DELETE TABLE AND EXIT");
	            System.out.println("______________________________________");
	            int ch=sc.nextInt();
	            switch(ch)
	            {
	                case 1:System.out.print("Enter Element: ");
	                    h.insert(sc.next());
	                    break;
	                case 2:System.out.print("Enter Element: ");
	                    h.serch(sc.next());
	                    break;
	                case 3:System.out.print("Enter Element: ");
	                    h.deleting(sc.next());
	                    break;
	                case 4:h.display();
	                    break;
	                case 5:h.deleteHashTable();
	                    System.exit(0);
	                default:System.out.println("Wrong Choice:");
	            }
	        }

	}

}
