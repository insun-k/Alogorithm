import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if (curr == '('){
                stack.add(curr);
            } else if(curr == ')') {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        
        if (!stack.isEmpty()) return false;
        return true;
	}
}
