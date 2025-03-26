import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        char[] arr = new char[numbers.length()];
        for(int i = 0; i < numbers.length(); i++){
            arr[i] = numbers.charAt(i);
        }
        
        String[] output = new String[numbers.length()];
        boolean[] visited = new boolean[numbers.length()];
        
        for(int i = 0; i < numbers.length(); i++){
            permutation(arr, output, visited, 0, i+1); 
        }
        
        int cnt = 0;
        for(int p : set){
            if (isPrime(p)){
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public static void permutation(char[] arr, String[] output, boolean[] visited, int depth, int r){
        if (depth == r){
            // 앞자리가 0이면 제외
            if (!output[0].equals("0")){
                StringBuilder sb = new StringBuilder();

                for(int i = 0; i<r; i++){
                    sb.append(output[i]);
                }
                // 순열 구한 후 set에 넣기
                set.add(Integer.parseInt(sb.toString()));
            }
            return;
        }
        
        for(int i = 0; i<arr.length; i++){
            if (!visited[i]){
                visited[i] = true;
                output[depth] = String.valueOf(arr[i]);
                permutation(arr, output, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }
    
    // 소수 찾기
    public boolean isPrime(int n){
        if (n == 1) return false;
        for(int i = 2 ; i < n; i++){
            if (n % i == 0) return false;
        }
        return true;
    }
    
}
