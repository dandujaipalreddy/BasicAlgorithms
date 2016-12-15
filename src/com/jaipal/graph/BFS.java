package com.jaipal.graph;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFS {

	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean marked[];
	private int[] toEdge;
	private int[] distTo;

	public BFS(Graph G, int src) {
		marked = new boolean[G.V()];
		toEdge = new int[G.V()];
		distTo = new int[G.V()];
		for (int i = 0; i < G.V(); i++)
			distTo[i] = INFINITY;
		bfs(G, src);
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter No of Vertices");
		int v = in.nextInt();
		System.out.println("Enter No of Edges");
		int e = in.nextInt();
		Graph G = new Graph(v, e);
		System.out.println("Enter (source,destination) of every edge");
		for (int i = 0; i < e; i++) {
			int src = in.nextInt();
			int dest = in.nextInt();
			G.addEdge(src, dest);
		}
		System.out.println("Enter Source[using BFS]");
		int source = in.nextInt();
		BFS bf = new BFS(G, source);
		for (int i = 0; i < G.V(); i++) {
			if (bf.hasPathTo(i)) {
				System.out.print("Has path to" + i);
				System.out.print("The Path is" + bf.pathTo(i));
				System.out.println("   distance from Source: " + bf.distTo(i));
			}

		}

	}

	private void bfs(Graph G, int s) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		marked[s] = true;
		distTo[s] = 0;
		while (!q.isEmpty()) {
			int v = q.remove();
			for (int k : G.adjacent(v)) {
				if (!marked[k]) {
					q.add(k);
					marked[k] = true;
					distTo[k] = distTo[v] + 1;
					toEdge[k] = v;
				}

			}

		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public int distTo(int v) {
		return distTo[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		int x;
		for (x = v; distTo[x] != 0; x = toEdge[x])
			path.push(x);
		path.push(x);
		return path;
	}

}
