import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        
        // 두 수를 합친 값 중 큰 값 찾기
        // ex. o1 : 10, o2 : 2 -> 102 vs 210 -> 210
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (str[0].equals("0")) {
            return "0";
        }
        
        for(int i = 0; i<str.length; i++){
            sb.append(str[i]);
        }
        return sb.toString();
 
    }
}
