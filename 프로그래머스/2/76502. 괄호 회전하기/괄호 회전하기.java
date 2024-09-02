import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            String rotatedS;
            
            if(i == 0) {
                rotatedS = s;
            } else {
                rotatedS = s.substring(i).concat(s.substring(0, i));
            }
            
            Stack<Character> stack = new Stack<> ();
            boolean isValid = true;
            
            for(int j = 0; j < s.length(); j++) {
                char curChar = rotatedS.charAt(j);
                
                if(curChar == '(' || curChar == '[' || curChar == '{') {
                    stack.push(curChar);
                } else {
                    if(stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    
                    char peekChar = stack.peek();
                    
                    if((peekChar == '(' && curChar == ')') ||
                       (peekChar == '[' && curChar == ']') ||
                       (peekChar == '{' && curChar == '}')) stack.pop();
                }
            }
            
            if(isValid && stack.size() == 0) answer++;
        }
        
        return answer;
    }
}