import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				graph[i][j] = in.nextInt();
		int source = in.nextInt();
		if (source <= 0 || source > n)
			throw new IllegalArgumentException("Number of vertices must be nonnegative");
		bfs(graph, source - 1);

	}

	static void bfs(int[][] graph, int source) {

		Queue<Integer> queue = new LinkedList<Integer>();
		int n = graph[source].length;
		boolean[] visited = new boolean[n];
		queue.add(source);
		int distance = 0;
		while (!queue.isEmpty()) {

			int x = queue.remove();
			distance++;
			visited[x] = true;
			for (int i = 0; i < n; i++) {
				if (graph[x][i] != 0  && !visited[i]) {
					queue.add(i);
					System.out.println("Distance From source To " + (i + 1) + " :" + distance);
					visited[i] = true;
				}
			}

		}
	}


}
