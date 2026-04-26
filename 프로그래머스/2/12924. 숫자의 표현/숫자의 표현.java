import java.util.*;

class Solution {
    public int solution(int n) {
        int l = 0;
        int r = 1;
        int sum = 1;
        int answer = 0;
        
        while (r <= n) {
            if (sum <= n) {
                if (sum == n) answer++;
                r++;
                sum += r;
            } else {
                sum -= l;
                l++;
            }
        }
        
        return answer;
    }
}