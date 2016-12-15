package com.jaipal.graph;
public class Edge implements Comparable<Edge> {

	private int v;
	private int w;
	private double weight;

	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	int either() {

		return v;
	}

	int other(int k) {
		return (k == v ? w : v);
	}

	double weight() {
		return weight;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if (this.weight > o.weight)
			return 1;
		else if (this.weight < o.weight)
			return -1;
		else
			return 0;
	}

}
