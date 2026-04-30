import java.util.*;

class Solution
{
    public int solution(String str)
    {
        int n = str.length();
        int answer = 1;
        
        for (int i = 0; i < n - 1; i++) {
            int len = 1;
            int len2 = 0;
            int s = i;
            int e = i;
            
            for (int j = 0; j < n / 2; j++) {
                s--;
                e++;
                
                if (s < 0 || e == n) break;
                if (str.charAt(s) != str.charAt(e)) break;
                len += 2;
            }
            
            if (str.charAt(i) == str.charAt(i + 1)) {
                len2 = 2;
                s = i;
                e = i + 1;
                
                for (int j = 0; j < n / 2; j++) {
                    s--;
                    e++;
                
                    if (s < 0 || e == n) break;
                    if (str.charAt(s) != str.charAt(e)) break;
                    len2 += 2;
                }
            }
            
            answer = Math.max(answer, Math.max(len, len2));
        }
        
        return answer;
    }
}