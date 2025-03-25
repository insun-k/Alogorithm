import java.util.*;

class Solution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville){
            queue.add(s);
        }
        
        int cnt = 0;
        while(queue.peek() < K){
            // 모든 음식을 K 이상 만들 수 없는 경우
            if (queue.size() < 2) return -1;
            
            int n = queue.poll() + (queue.poll() * 2);
            queue.add(n);
            cnt++;
        }
        
        return cnt;
	}
}
