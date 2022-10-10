import java.util.HashSet;

public class RecursionMedium {

	//tower of Hanoi
	private static void towerOfHanoi(int n,String src,String helper,String dest) {
		if(n==1) {
			System.out.println("transfer disk from "+n + " from "+src+" to  "+dest);
		    return;	
		}
		//transfer top n-1 from src to helper using dest as 'helper
		towerOfHanoi(n-1,src,dest,helper);
		
		//transfer nth from src to dest
		System.out.println("transfer disk from "+n + " from "+src+" to  "+dest);
	    
		//transfer n-1 form helper to dest using src as helper
		towerOfHanoi(n-1,helper,src,dest);
	
	}
	
	//print string in reverse
	private static void stringInReverse(String str,int indx) {
	   if(indx==0) {
		   System.out.print(str.charAt(indx));
		   return;
	   }
		
		System.out.print(str.charAt(indx));
		stringInReverse(str,indx-1);
	}
	
	//return string in reverse
	private static String reverseString(String s , String newStr, int ind) {
		if(ind==-1)
			return newStr;
		
		return reverseString(s,newStr+=s.charAt(ind),ind-1);
	}
	
	//find first and last occurence 
	public static int first=-1;
	public static int last = -1;
	
	private static void getIndices(String s,char e,int indx) {
		if(indx==s.length())
			return;
		
		if(s.charAt(indx)==e) {
			if(first==-1)
				first=indx;
			else 
				last=indx;
		}
		getIndices(s,e,indx+1);
	}
	
	//check if array is sorted or not
	private static boolean isSorted(int a[],int indx) {
		if(indx==a.length-1)
			return true;
	 	
		if(!isSorted(a,indx+1))
			return false;
		
		
		return (a[indx]>a[indx+1]);
			
	 }
	
	//remove duplicates in a string
	private static String removeDup(String s,String ans,int indx,boolean isPresent[]) {
		if(indx==s.length())
			return ans;
		if(isPresent[s.charAt(indx)-'a']) {
			return removeDup(s,ans,indx+1,isPresent);
		}else {
			isPresent[s.charAt(indx)-'a']=true;
			return removeDup(s,ans+s.charAt(indx),indx+1,isPresent);
		}
	}
	
	//print all the subsequences of a string
	 private static void printSub(String s,int indx,String ans) {
         if(indx==s.length()) {
        	 System.out.println(ans);
        	 return ;
        	 
         }
		 
		 printSub(s,indx+1,ans+s.charAt(indx));
		 printSub(s,indx+1,ans);
		 
	 }
	
	//print all unique the subsequences of a string
		 private static void printUniqueSub(String s,int indx,String ans,HashSet<String> set) {
	         if(indx==s.length()) {
	        	 if(set.contains(ans))
	        		 return;
	        	 
	        	 System.out.println(ans);
		        	 set.add(ans);	 
	        	 return;
	         }
			 
			 printUniqueSub(s,indx+1,ans+s.charAt(indx),set);
			 printUniqueSub(s,indx+1,ans,set);
			 
		 }
		//print keypad combination
		 private static String keypad[] = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	
		 private static void printKeyPadComb(String number,int indx,String res) {
			 if(indx==number.length()) {
				 System.out.println(res);
				 return;
			 }
			 
			 for(int i=0;i<keypad[number.charAt(indx)-'0'].length();i++){
				 char c=keypad[number.charAt(indx)-'0'].charAt(i);
				 printKeyPadComb(number,indx+1,res+c);
			 }
			 
			 
		 }
		 
		 
	public static void main(String[] args) {
		int n = 4;
		int a[]= {1,2,3,3};
//		towerOfHanoi(n,"A","B","C");
        String s ="aaa"; //f=2 , l=8
//		stringInReverse(s,s.length()-1);
//	  System.out.println(reverseString(s,"",s.length()-1));
//	 getIndices(s,'a',0);
//	 System.out.print("first occur: "+ first +" last occur: "+ last);
//	 System.out.println(isSorted(a,0));
	 boolean b[] = new boolean[26]; 
//        System.out.println(removeDup(s,"",0,b));
//	  printUniqueSub(s,0,"",new HashSet<>());
	String number ="3";
	printKeyPadComb(number,0,"");
	}

}
