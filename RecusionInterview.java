import java.util.ArrayList;

public class RecusionInterview {

	//print permutation of a string 
	private static void printPermut(String s , String permutation) {
		if(s.length()==0) {
			System.out.println(permutation);
			return;
		}
		
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			String newStr = s.substring(0,i)+s.substring(i+1);
			printPermut(newStr,permutation+ch);
		}
	}
	
	//count total paths in a matrix from 0,0 to (n,m)
	
	private static int countPath(int i,int j,int n,int m) {
		
		if(i==n-1 || j==m-1)
			return 1;
		return countPath(i+1,j,n,m)+countPath(i,j+1,n,m);
	}
	//total ways to place a tile of 1*M into a N*M floor
	private static int placeTile(int n,int m) {
		
		if(n==m)
			return 2;
		
		if(n<m)
			return 1;
		 
		//place vertical
		int verticalPlace = placeTile(n-m,m);
		
//		place horizontal
		int horizontalPlace = placeTile(n-1,m);
		
		return verticalPlace+horizontalPlace;
	}
	
	//total no of ways to invite guest in single or in pair
	private static int totalGuest(int n) {
		if(n<=1)
			return 1;
		
		//single ways
		int single = totalGuest(n-1);
		//in pair
		int pair = (n-1)*totalGuest(n-2);
	  return single+pair;
	}
	
	//print subsets function
	private static void printSubsets(ArrayList<Integer> subset) {
	for(int i=0;i<subset.size();i++)
		System.out.print(subset.get(i)+" ");
	System.out.println();
 }
	//print all  the subset of a set of first n natural number
	
	private static void findSubsets(int n,ArrayList<Integer> subset) {
		
		if(n==0) {
			printSubsets(subset);
			return;
		}
		
	//add hoga
		subset.add(n);
		findSubsets(n-1,subset);
		
		
	//add nhi hoga	
	  subset.remove(subset.size()-1);
	  findSubsets(n-1,subset);
	}
	
	public static void main(String[] args) {
		String s = "ABC";
//		printPermut(s,"");
//         System.out.println(countPath(0,0,3,3));
	
//	 System.out.println(placeTile(6,3));
	
	System.out.println(totalGuest(4));
        findSubsets(4,new ArrayList<Integer>());	 
	}

}
 