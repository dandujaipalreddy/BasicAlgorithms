import java.util.Scanner;

public class Finding_Cycle {

	private boolean[] rec_stack;
	private boolean[] marked;

	public Finding_Cycle(Graph G) {

		rec_stack = new boolean[G.V()];
		marked = new boolean[G.V()];
		for (int i = 0; i < G.V(); i++) {
			if (dfs(G, i))
				System.out.println("Found Cycle");
		}

	}

	private boolean dfs(Graph G, int v) {

		if (!marked[v]) {
			marked[v] = true;
			rec_stack[v] = true;
			for (int k : G.adjacent(v)) {
				if (!marked[k] && dfs(G, k))
					return true;
				else if (rec_stack[k])
					return true;
			}

		}
		rec_stack[v] = false;
		return false;
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
		Finding_Cycle f = new Finding_Cycle(G);

	}

}
