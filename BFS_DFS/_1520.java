// [BOJ-Gold2] 1520_내리막길
package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1520 {
	static int n;
	static int m;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] dp;

	public static int dfs(int x, int y) {
		if (x == m - 1 && y == n - 1) {
			return 1;
		}

		// 방문했으면 dp 리턴
		if (dp[x][y] != -1) {
			return dp[x][y];
		}

		dp[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < m && 0 <= ny && ny < n) {
				if (graph[x][y] > graph[nx][ny]) {
					dp[x][y] += dfs(nx, ny);
				}
			}
		}
		return dp[x][y];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		graph = new int[m][n];
		visited = new boolean[m][n];
		dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0));

	}
}
