package Graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    
	LinkedList<Integer> l[];
	public TopologicalSort(int len) {
		l =new LinkedList[len];
		for(int i = 0; i<len;i++)
			l[i] = new LinkedList<>();
	}

    //creating edges
    //Topological sort is only possible on Directed Acyclic Graph
	public void addEdge(int s, int d) {
		l[s].add(d);
	}
	//print the adjancy list
	public void printGraph() {
		for(int i = 0; i<l.length;i++) {
			System.out.print("|" + i +"|");
			for(int j = 0; j<l[i].size();j++)
				System.out.print("-->"+l[i].get(j));
			System.out.println();
		}
	}
	//perform topological Sort
	public void topologicalSort() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited  = new boolean[l.length];
		for(int i = 0; i<l.length;i++) {
			if(!visited[i])
				topologicalSortUtil(i,visited,stack);
		}
		while(!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	public void topologicalSortUtil(int current, boolean[] visited, Stack<Integer> stack) {
		for(int i = 0; i<l[current].size();i++) {
			int n = l[current].get(i);
			if(!visited[n])
				topologicalSortUtil(n,visited,stack);
		}
		visited[current] = true;
		stack.push(current);
	}
	public static void main(String[] args) {
                
		TopologicalSort g = new TopologicalSort(6);
		  g.addEdge(5, 2);
	        g.addEdge(5, 0);
	        g.addEdge(4, 0);
	        g.addEdge(4, 1);
	        g.addEdge(2, 3);
	        g.addEdge(3, 1);

	        g.printGraph();
	        System.out.println("Topological sort of the given graph:");
	        g.topologicalSort();
	}

}
