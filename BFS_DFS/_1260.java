package BFS_DFS;
// [BOJ-Sliver2] 1260_DFS와 BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260 {
	static int n, m, v;
	static boolean[] visited;
	static boolean[][] graph;

	static StringBuilder result = new StringBuilder();

	public static void dfs(int start) {

		for (int i = 1; i <= n; i++) {
			if (graph[start][i] && !visited[i]) {
				visited[i] = true;
				result.append(i).append(" ");
				dfs(i);
			}
		}
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			result.append(curr).append(" ");
			for (int i = 1; i <= n; i++) {
				if (graph[curr][i] && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		graph = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}

		visited[v] = true;
		result.append(v).append(" ");
		dfs(v);
		result.append('\n');

		Arrays.fill(visited, false);
		bfs(v);

		System.out.println(result);

	}
}
