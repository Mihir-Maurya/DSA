
public class RecursionEasy {
   //print Number from 5 to 1
  private static void printN(int n) {
		if(n==0)
			return;
		
		System.out.print(n + " ");
		printN(n-1);
  }
 
//print Number from 1 to 5
  private static void print1To5(int n) {
		if(n==0)
			return;
		print1To5(n-1);
		System.out.print(n + " ");
		
	}
 
	//print sum of first n natural number
  private static int printSumOfN(int n) {
	  if(n==1)
		  return 1;
	  return n+printSumOfN(n-1);
  }
//print sum of first n natural number
 private static void printSum(int i,int n,int sum) {
	 if(i==n) {
		 sum+=i;
		 System.out.println(sum);
		 return;
	 }
	 
	 sum+=i;
	 printSum(i+1,n,sum);
 }
  
 //print factorial of a number n
 private static void fact(int n,int fac) {
	 if(n==1) {
		 System.out.print(fac);
		 return;
	 }
	 
	 fac*=n;
	 fact(n-1,fac);
 }
 
 //another way to cal factorial using recursion
 private static int fac(int n) {
	 if(n==1 || n==0)
		 return 1;
	 
	 int partialAns=fac(n-1);
	 return n*partialAns;
 }
  
 //print fibonacci sequence till nth term
 private static void printFibo(int a, int b ,int n) {
     if(n==0)
    	 return;
	 int c=a+b;
	 System.out.print(c+ " ");
   printFibo(b,c,n-1);
 }
  
	public static void main(String[] args) {
	
		
//		printN(n);
//		print1To5(n);
//       printSum(1,5,0);
//	       fact(5,1);
      int a=0, b=1 ,n=10;
      System.out.print(a +" "+b+" ");
	printFibo(a,b,n);
	}

}
