import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {

	private int[] color;

	public Bipartite(Graph G) {

		color = new int[G.V()];
		for (int i = 0; i < G.V(); i++)
			color[i] = -1;
		if (isPartite(G, 0))
			System.out.println("The Graph is Bipartite");
		else
			System.out.println("The Graph is not Bipartite");
		for (int k : color)
			System.out.println(k);
	}

	public boolean isPartite(Graph G, int s) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);

		color[s] = 0;
		while (!q.isEmpty()) {
			int v = q.remove();
			for (int k : G.adjacent(v)) {
				if (color[k] == -1) {
					q.add(k);
					color[k] = 1 - color[v];
				} else if (color[v] == color[k])
					return false;

			}

		}
		return true;

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
		Bipartite bp = new Bipartite(G);

	}

}
