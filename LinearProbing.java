package Hashing;

import java.util.ArrayList;
import java.util.Scanner;

public class LinearProbing {
  String[] hashTable;
  int usedCells;
  //empty array is created
  public LinearProbing(int length) {
	  hashTable = new String[length];
	  usedCells = 0;
  }
  //hashFunction to be used on keys
  private int hashFunction(String s, int m) {
	  char ch[] = s.toCharArray();
	  int sum = 0;
	  for(int i = 0; i<s.length();i++) {
		  sum +=ch[i];
	  }
	  return sum % m;
  }
  //insert Value in HashTable
  public void insert(String value) {
	  double loadFactor = usedCells * 1.0 / hashTable.length;
	  if(loadFactor>=0.75)//we need to rehash in new table doubling the size
	  {
		  rehashKeys(value);
		  
	  }else {
		  int index = hashFunction(value, hashTable.length);
		 for(int i = index; i<index + hashTable.length;i++) {
			 int newIndex = i % hashTable.length;
			 if(hashTable[newIndex] == null) {
				 hashTable[newIndex] = value;
				 usedCells++;
				 break;
			 }
		 }
	  }
  }
//Creates a new HashTable and does ReHashing
	private void rehashKeys(String value) {
	usedCells = 0; // reset it as we are dealing with fresh HashTabl
	ArrayList<String> data = new ArrayList<>();
	for(String s : hashTable) {
		if(s != null)
			data.add(s);
	}
	data.add(value);
	hashTable = new String[hashTable.length*2];// make new table with double size
	for(String s : data)
		insert(s);// push all old data into new table
	
	
}
	//serching in hashTable
	public void serching(String value) {
		int index = hashFunction(value, hashTable.length);
		for(int i = index; i<index+hashTable.length;i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].equals(value)) {
				System.out.println("value is found at index " + newIndex);
				return;
			}
		}
		System.out.println("value is not found");
	}
	//deleting in hashTable
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
	//display the hashTable
	public void display() {
		for(int i = 0; i<hashTable.length;i++) {
			System.out.println(i + " - " + hashTable[i] );
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
	        LinearProbing h = new LinearProbing(sc.nextInt());

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
	                    h.serching(sc.next());
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
