package Hashing;

import java.util.ArrayList;
import java.util.Scanner;

public class QuadraticProbing {
   String [] hashTable;
   int usedCells ;
   //empty array is created
   public QuadraticProbing(int length) {
	   hashTable = new String[length];
	   usedCells = 0;
   }
   //hashfunction
   public int hashFunction(String s, int m) {
	   char ch[] = s.toCharArray();
	   int sum = 0;
	   for(int i = 0; i<s.length();i++) {
		   sum +=ch[i];
	   }
	   return sum % m;
   }
   //insert a value in hashTable
   public void insert(String value) {
	   double loadFactor = usedCells * 1.0 / hashTable.length;
	   if(loadFactor >=0.75) {
		   rehashKeys(value);
		   
	   }else {
		   int index = hashFunction(value, hashTable.length);
		   int counter = 0;
		   for(int i = index;i<index+ hashTable.length;i++) {
			   int newIndex = (index+(counter*counter)) % hashTable.length;
			   if(hashTable[newIndex] == null) {
				   hashTable[newIndex] = value;
				   usedCells++;
				   return;
			   }
			   counter++;
		   }
	   }
   }
   
	private void rehashKeys(String value) {
	usedCells = 0; //reset it as we are now dealing with fresh HashTable
	ArrayList<String> data = new ArrayList<>();
	for(String s: hashTable) {
		if(s != null)
		data.add(s);
	}
	data.add(value);
	hashTable = new String[hashTable.length*2];
	for(String s : data)
		insert(s);
}
	//serching a value in hashtable
	public void search(String value) {
		int index = hashFunction(value, hashTable.length);
		for(int i = index; i<index+hashTable.length;i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].equals(value)) {
				System.out.println("found at index " + newIndex);
				return;
			}
		}
		System.out.println("value not found");
	}
	//deleting 
	public void delete(String value) {
		int index = hashFunction(value, hashTable.length);
		for(int i = index; i<index+hashTable.length;i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].equals(value)) {
				hashTable[newIndex] = null;
				return;
			}
		}
		System.out.println("value not found");
	}
    // Display the hash table
    public void display()
    {
        for (int i = 0; i < hashTable.length; i++)
        {
            //if(hashTable[i]!=null)
            System.out.println(i+" - "+hashTable[i]);
        }
    }
    //Deletes entire HashTable
    public void deleteHashTable()
    {
        hashTable = null;
    }
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter length: ");
	        QuadraticProbing h = new QuadraticProbing(sc.nextInt());

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
	                    h.search(sc.next());
	                    break;
	                case 3:System.out.print("Enter Element: ");
	                    h.delete(sc.next());
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
