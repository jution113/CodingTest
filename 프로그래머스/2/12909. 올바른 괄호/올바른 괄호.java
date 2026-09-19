import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<> ();
        
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '(') stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        if (!stack.isEmpty()) return false;
        return true;
    }
}