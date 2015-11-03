import java.util.Scanner;
import java.util.Stack;

public class DFS {

	private int src;
	private int[] toEdge;
	private boolean[] marked;

	public DFS(Graph G, int v) {
		src = v;
		toEdge = new int[G.V()];
		marked = new boolean[G.V()];
		dfs(G, v);
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int k : G.adjacent(v)) {
			if (!marked[k]) {
				toEdge[k] = v;
				dfs(G, k);
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != src; x = toEdge[x])
			path.push(x);
		path.push(src);
		return path;
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
		System.out.println("Enter Source[using DFS]");
		int source = in.nextInt();
		DFS df = new DFS(G, source);
		for (int i = 0; i < G.V(); i++) {
			if (df.hasPathTo(i)) {
				System.out.print("Has path to" + i);
				System.out.println("The Path is" + df.pathTo(i));
			}

		}
	}

}
