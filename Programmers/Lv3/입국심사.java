class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = times[times.length - 1] * (long)n;  // 모든 사람이 가장 느리게 심사 받을때
        long result = 0;
        
        while (left <= right){
            long mid = (left + right) / 2;
            
            long curr = 0;
            for(int time : times){
                curr += mid / time;
            }
            
            if (curr >= n){
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
