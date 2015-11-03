import java.util.LinkedList;
import java.util.Scanner;

public class Graph {

	private final int V;
	private int E;
	private LinkedList<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int v, int e) {
		V = v;
		E = e;
		adj = new LinkedList[V];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	public void addEdge(int src, int dest) {
		adj[src].add(dest);
		adj[dest].add(src);

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		for (int i = 0; i < G.V(); i++) {
			System.out.println(i + ":" + G.adjacent(i));
		}
		in.close();
	}

}
