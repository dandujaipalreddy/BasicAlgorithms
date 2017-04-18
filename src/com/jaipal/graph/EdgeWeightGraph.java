package com.jaipal.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EdgeWeightGraph {

	
	private final int V;
    private int E;
    private LinkedList<Edge>[] adj;
    public EdgeWeightGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Edge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Edge>();
        }
    }

 

    public int V() {
        return V;
    }

  
    public int E() {
        return E;
    }
 
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

   
    public Iterable<Edge> adj(int v) {
       
        return adj[v];
    }

   
    public int degree(int v) {
        return adj[v].size();
    }

  
    public Iterable<Edge> edges() {
        List<Edge> list = new ArrayList<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // only add one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }
 
}
