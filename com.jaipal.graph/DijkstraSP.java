package com.jaipal.graph;
import java.util.Stack;


public class DijkstraSP {

	private double[] distTo;
	private DirectedEdge[] edgeTo;
	private IndexMinPQ<Double> pq;

	public DijkstraSP(EdgeWeightDigraph G, int S) {

		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[S] = 0.0;
		pq = new IndexMinPQ<Double>(G.V());
		pq.insert(S, distTo[S]);
		while (!pq.isEmpty()) {
			int v = pq.delMin();
			for (DirectedEdge e : G.adj(v))
				relax(e);
		}

	}

	private void relax(DirectedEdge e) {
		int v = e.from(), w = e.to();
		if (distTo[w] > distTo[v] + e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
			if (pq.contains(w))
				pq.decreaseKey(w, distTo[w]);
			else
				pq.insert(w, distTo[w]);
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}

}
