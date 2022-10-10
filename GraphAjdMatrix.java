package Graph;

import java.util.*;

public class GraphAjdMatrix {
   
	//print BFS time complexity O(V+E) and space complexity O(V)
	private static void printBFS(int adj_mat[][]) {
		int v=adj_mat.length;
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++) {
			if(!visited[i])
				printBFSHelper(adj_mat,i,visited);
		}
	}
	//BFS helper
	
	
	private static void printBFSHelper(int[][] adj_mat,int sv,boolean visited[]) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(sv);
		visited[sv]=true;
		int v =  adj_mat.length;
		while(!q.isEmpty()) {
			int temp=q.poll();
			System.out.println(temp);
			for(int i=0;i<v;i++) {
				if(adj_mat[temp][i]==1 && !visited[i]) {
					q.offer(i);
					visited[i]=true;
				}
			}
		}
	 
	}
	
	//dfs helper
	private static void printDFSHelper(int adj_mat[][],int sv,boolean visited[]) {
		System.out.println(sv);
		visited[sv]=true;
		int v=adj_mat.length;
		for(int i=0;i<v;i++) {
			if(adj_mat[sv][i]==1 && visited[i]==false)
				printDFSHelper(adj_mat,i,visited);
		}
	}
	     
      //time complexity of dfs O(V+E) and space complexity of dfs is O(V)	
	private static void printDFS(int adj_mat[][]) {
	 int v=adj_mat.length;
	 boolean visited[]=new boolean[v];
	 for(int i=0;i<v;i++) {
		 if(!visited[i])
			 printDFSHelper(adj_mat,i,visited);
	 }
		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of vertex: ");
        int v= scn.nextInt();
        System.out.println("Enter the number of Edges: ");
        int e= scn.nextInt();
	
	    int adj_mat[][]=new int[v][v];
	    
	    for(int i=0;i<e;i++) {
	    	int sv=scn.nextInt();
	    	int ev=scn.nextInt();
	    	adj_mat[sv][ev]=1;
	    	adj_mat[ev][sv]=1;
	    }
	    //print dfs
	     System.out.println("dfs traversal of the graph");
	    printDFS(adj_mat);
	    //print BFS 
	    System.out.println("bfs traversal of the graph");
		    printBFS(adj_mat);
		
	
	}

}
