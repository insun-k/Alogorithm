class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int result){
        if (depth == numbers.length){
            if (target == result){
                answer++;
                return;
            }
        } else{
            int minus = result - numbers[depth];
            int plus = result + numbers[depth];
            
            dfs(numbers, target, depth+1, minus);
            dfs(numbers, target, depth+1, plus);
        }
    }
}
