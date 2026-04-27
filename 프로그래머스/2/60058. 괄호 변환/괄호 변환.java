import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.equals("") || isCorrect(p)) return p;
        
        int balancedLen = getBalancedLength(p);
        
        String u = p.substring(0, balancedLen);
        String v = p.substring(balancedLen, p.length());
        
        String recurV = solution(v);
        
        StringBuilder sb = new StringBuilder();
        if (isCorrect(u)) {
            sb.append(u);
            sb.append(recurV);
        } else {
            sb.append("(");
            sb.append(recurV);
            sb.append(")");
            sb.append(reverse(u.substring(1, u.length() - 1)));
        }
        
        return sb.toString();
    }
    
    private boolean isCorrect(String brackets) {
        ArrayDeque<String> stack = new ArrayDeque<> ();
        
        for (int i = 0; i < brackets.length(); i++) {
            String bracket = brackets.substring(i, i + 1);
            
            if (bracket.equals("(")) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty() ? true : false;
    }
    
    private int getBalancedLength(String brackets) {
        ArrayDeque<String> stack = new ArrayDeque<> ();
        
        for (int i = 0; i < brackets.length(); i++) {
            String bracket = brackets.substring(i, i + 1);
            
            if (stack.isEmpty() || bracket.equals(stack.peek())) {
                stack.push(bracket);
                continue;
            }
            
            if (!bracket.equals(stack.peek())) {
                stack.pop();
                if (stack.isEmpty()) return i + 1;
            }
        }
        
        return brackets.length();
    }
    
    private String reverse(String brackets) {
        StringBuilder sb = new StringBuilder();
        
        for (char bracket : brackets.toCharArray()) {
            char c = bracket == '(' ? ')' : '(';
            sb.append(c);
        }
        
        return sb.toString();
    }
}