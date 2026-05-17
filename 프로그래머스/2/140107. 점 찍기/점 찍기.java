import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long dPow = (long) d * d;
        long answer = 0;

        outer:
        for (long a = 0; a * k <= d; a++) {
            long x = a * k;
            long xPow = x * x;
            answer += (long) (Math.sqrt(dPow - xPow ) / k) + 1;
        }
        
        return answer;
    }
}