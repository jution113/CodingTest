import java.util.*;

class Solution {
    static final char[] BASE = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        int num = 0;
        
        f: while (true) {
            String basedNum = convertBase(n, num);
            
            for (char c : basedNum.toCharArray()) {
                cnt++;
                if ((cnt - 1) % m == p - 1) {
                    answer.append(c);
                    if (answer.length() == t)
                        break f;
                }
            }
            num++;
        }
        
        return answer.toString();
    }
    
    private String convertBase(int base, int origin) {
        StringBuilder sb = new StringBuilder();
        
        while (origin >= base) {
            sb.append(BASE[origin % base]);
            origin /= base;
        }
        sb.append(BASE[origin]);
        return sb.reverse().toString();
    }
}