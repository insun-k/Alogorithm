// [BOJ-Silver1] 2667_단지번호붙이기
package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2667 {
	static int n;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int count;
	static List<Integer> result;

	static void dfs(int x, int y) {
		visited[x][y] = true;
		count += 1;  // 단지내 집의 수
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (graph[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					graph[nx][ny] = 0;
					dfs(nx, ny);
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		result = new ArrayList<>();

		n = Integer.parseInt(br.readLine());

		visited = new boolean[n][n];
		graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}

		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				if (graph[a][b] == 1 && !visited[a][b]) {
					count = 0;
					dfs(a, b);
					result.add(count);
				}
			}
		}

		Collections.sort(result);

		sb.append(result.size()).append('\n');
		for (int r : result) {
			sb.append(r).append('\n');
		}

		System.out.println(sb);

	}

}
