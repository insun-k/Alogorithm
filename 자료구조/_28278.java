package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _28278 {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			switch (str.nextToken()) {
				case "1":
					stack.push(Integer.parseInt(str.nextToken()));
					break;
				case "2":
					if (stack.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(stack.pop()).append('\n');
					}
					break;
				case "3":
					sb.append(stack.size()).append('\n');
					break;
				case "4":
					if (stack.isEmpty()) {
						sb.append(1).append('\n');
					} else {
						sb.append(0).append('\n');
					}
					break;
				case "5":
					if (stack.empty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(stack.peek()).append('\n');
					}
					break;
			}
		}

		System.out.print(sb.toString());

	}
}
