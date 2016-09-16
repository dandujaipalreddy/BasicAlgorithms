package com.jaipal.graph;
import java.util.LinkedList;

public class Digraph {

	private final int V;
	private int E;
	private LinkedList<Integer>[] adj;
	private int[] indegree;

	@SuppressWarnings("unchecked")
	public Digraph(int v) {
		if (v < 0)
			throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		V = v;
		E = 0;
		indegree = new int[v];
		adj = new LinkedList[V];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void addEdge(int src, int dest) {
		adj[src].add(dest);
		indegree[dest]++;
		E++;

	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public LinkedList<Integer> adjacent(int src) {
		return adj[src];
	}

	public int outdegree(int v) {

		return adj[v].size();
	}

	public int indegree(int v) {

		return indegree[v];
	}

	public Digraph reverse() {
		Digraph R = new Digraph(V);
		for (int v = 0; v < V; v++) {
			for (int w : adjacent(v)) {
				R.addEdge(w, v);
			}
		}
		return R;
	}

}
