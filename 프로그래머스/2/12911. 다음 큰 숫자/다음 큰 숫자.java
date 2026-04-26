import java.util.*;

class Solution {
    public int solution(int n) {
        int nBitCnt = Integer.bitCount(n);
        int answer = n + 1;
        
        while (nBitCnt != Integer.bitCount(answer)) {
            answer++;
        }
        
        return answer;
    }
}