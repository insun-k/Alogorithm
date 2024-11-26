package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1167 {
	static int v;
	static ArrayList<Node>[] list;
	static boolean[] visited;

	public static class Node {
		int e;
		int c;

		public Node(int e, int c) {
			this.e = e;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		v = Integer.parseInt(br.readLine());
		list = new ArrayList[v + 1];

		// 인접리스트
		for (int i = 1; i < v + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			while (true) {
				int e = Integer.parseInt(st.nextToken());

				if (e == -1)
					break;
				int c = Integer.parseInt(st.nextToken());
				list[start].add(new Node(e, c));
			}
		}

	}
}
