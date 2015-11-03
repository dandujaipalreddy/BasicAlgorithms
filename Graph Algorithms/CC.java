
public class CC {

	private boolean marked[];
	private int[] id;
	private int[] size;
	private int count;

	public CC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		size = new int[G.V()];
		count = 0;
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i]) {
				dfs(G, i);
				count++;
			}
		}
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		size[count]++;
		for (int w : G.adjacent(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public int size(int v) {
		return size[id[v]];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return count;
	}

	public boolean connected(int v, int w) {
		return id(v) == id(w);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
