import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] sizeCnt = new int[10000001];
        int answer = 0;
        int cnt = 0;
        
        for (int size : tangerine) {
            sizeCnt[size]++;
        }
        
        Arrays.sort(sizeCnt);

        for (int i = sizeCnt.length - 1; i > 0; i--) {
            cnt += sizeCnt[i];
            answer++;
            
            if (cnt >= k)
                break;
        }
        return answer;
    }
}