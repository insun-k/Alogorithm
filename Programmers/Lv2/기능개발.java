import java.util.*;

public class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> resultList = new ArrayList<>();

		// 작업 일 수 계산
		for(int i = 0; i < progresses.length; i++){
			double days = (100 - progresses[i]) / (double)speeds[i];
			queue.add((int)(Math.ceil(days)));
		}

		int max = queue.poll();
		int cnt = 1;
		while(!queue.isEmpty()){
			int curr = queue.poll();
			// 일 수가 더 크면 cnt 1로 초기화
			if (curr > max){
				max = curr;
				resultList.add(cnt);
				cnt = 1;
			} else {
				// 일 수가 작으면 cnt만 증가
				cnt++;
				continue;
			}
		}
		resultList.add(cnt);

		int[] result = new int[resultList.size()];
		for(int i = 0; i < resultList.size(); i++){
			result[i] = resultList.get(i);
		}

		return result;
	}
}
