import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i = 0; i < s.length; i++) {
            String x = s[i];
            StringBuilder sb = new StringBuilder();
            StringBuilder mid = new StringBuilder();
            
            for (int j = 0; j < x.length(); j++) {
                char c = x.charAt(j);
                if (c == '0' && is11(sb)) {
                    sb.delete(sb.length() - 1, sb.length());
                    sb.delete(sb.length() - 1, sb.length());
                    mid.append("110");
                    continue;
                }
                sb.append(c);
            }
            
            int last0Idx = sb.lastIndexOf("0");
            sb.insert(last0Idx + 1, mid.toString());
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    private boolean is11(StringBuilder sb) {
        int n = sb.length();
        return n >= 2 && sb.charAt(n - 2) == '1' && sb.charAt(n - 1) == '1';
    } 
}