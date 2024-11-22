// [BOJ-Gold5] 10026_적록색약
package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10026 {
	static int n;
	static String[][] graph;
	static boolean[][] visited;

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	static String[] color = {"R", "B", "G"};

	static void dfs(int x, int y) {
		visited[x][y] = true;
		String color = graph[x][y];
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (graph[nx][ny].equals(color) && !visited[nx][ny]) {
					dfs(nx, ny);
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		graph = new String[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = String.valueOf(str.charAt(j));
			}
		}

		int count = 0;

		// 색약 아닌 사람
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					count += 1;
				}
			}
		}
		System.out.print(count + " ");

		// G를 R로 변환
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j].equals("G")) {
					graph[i][j] = "R";
				}
			}
		}

		// 색약 아닌 사람
		// visited, count 초기화
		int count2 = 0;
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					count2 += 1;
				}
			}
		}
		System.out.print(count2);

	}

}
