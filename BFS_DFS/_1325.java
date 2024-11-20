// [BOJ-Silver1] 1325_효율적인 해킹
package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _1325 {
	static int n;
	static int m;
	static int count;

	static ArrayList<Integer>[] list;
	static boolean[] visited;

	static void dfs(int now) {
		visited[now] = true;
		count += 1;
		for (int i : list[now]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			// count랑 visited 초기화
			count = 0;
			Arrays.fill(visited, false);
			dfs(i);
			result.add(count);
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			int now = result.get(i);
			if (max < now) {
				max = now;
				sb.setLength(0);
				sb.append(i + 1).append(' ');
			} else if (max == now) {
				sb.append(i + 1).append(' ');
			}
		}
		System.out.println(sb);
	}

}
