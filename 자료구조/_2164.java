// [BOJ-Silver4] 2164_카드2
package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		while (!queue.isEmpty()) {
			queue.poll();

			if (queue.size() == 1) {
				break;
			}
			queue.add(queue.poll());
		}

		System.out.println(queue.peek());
	}
}
