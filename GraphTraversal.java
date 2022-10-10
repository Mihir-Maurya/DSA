package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {
    LinkedList<Integer> li[];
    //creating adjacency list
    //creating vertices
    
    public GraphTraversal(int l) {
    	li = new LinkedList[l];
    	for(int i = 0; i<l;i++)
    		li[i] = new LinkedList<>();
    }
    //creating edge
    public void addEdge(int s, int d) {
    	li[s].add(d);
    	li[d].add(s);
    }
    
    //print the adjancency list
    public void printGraph() {
    	for(int i = 0; i<li.length;i++) {
    		System.out.print("|" +i+ "|");
    		
    		for(int j = 0; j<li[i].size();j++)
    			System.out.println("-->" + li[i].get(j));
    		System.out.println();
    	}
    }
    
    //BFS Traversal
    public void printBFS(int s) {
    	boolean[] visited = new boolean[li.length];
    	Queue<Integer> q = new LinkedList<>();
    	visited[s] = true;
    	q.add(s);
    	while(!q.isEmpty()) { 
    		s = q.remove();
    		System.out.print(s + "");
    		for(int i = 0; i<li[s].size();i++) {
    			 int n = li[s].get(i); 
    			if(!visited[n]) {
    				visited[n] = true;
    				q.add(n);
    			}
    		}
    	}
    	System.out.println();	
    }
    //DFS traversal
    public void printDFS(int s) {
    	boolean[] visited = new boolean[li.length];
    	recursiveDFS(s,visited);
    	System.out.println();
    }
    
    //DFS utility function
    public void recursiveDFS(int s, boolean[] visited) {
    	visited[s] = true;
    	System.out.println(s +" ");
    	for(int i = 0; i<li[s].size();i++) {
    		int n = li[s].get(i);
    		if(!visited[n])
    			recursiveDFS(n,visited);
    	}
    }
	public static void main(String[] args) {
		GraphTraversal g = new GraphTraversal(4);
		g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
		g.printGraph();
		 System.out.print("BFS = ");
//	        g.printBFS(2);
		 g.printDFS(2);

	}

}
