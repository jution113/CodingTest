import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<> ();
            
            for (int j = 0; j < len; j++) {
                char c = s.charAt((i + j) % len);
                
                if (!stack.isEmpty()) {
                    char c2 = stack.peek();
                
                    if ((c == ']' && c2 == '[') || (c == '}' && c2 == '{') || (c == ')' && c2 == '(')) {
                        stack.pop();
                        continue;
                    }
                }
                
                stack.push(c);
            }
            
            if (stack.isEmpty())
                answer++;
        }
        
        return answer;
    }
}