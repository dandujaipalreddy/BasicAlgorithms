package com.jaipal.graph;
import java.util.LinkedList;

public class EdgeWeightDigraph {

	
	private final int V;
    private int E;
    private LinkedList<DirectedEdge>[] adj;
    public EdgeWeightDigraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        adj = (LinkedList<DirectedEdge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

 

    public int V() {
        return V;
    }

  
    public int E() {
        return E;
    }
 
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        E++;
    }

   
    public Iterable<DirectedEdge> adj(int v) {
       
        return adj[v];
    }

   
    public int degree(int v) {
        
        return adj[v].size();
    }

 
}
