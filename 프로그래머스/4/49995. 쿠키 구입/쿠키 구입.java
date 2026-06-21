import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int n = cookie.length;
        int[] prefixSum = new int[n];
        
        prefixSum[0] = cookie[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + cookie[i];
        
        for (int m = 0; m < n - 1; m++) {
            int lSum = prefixSum[m];
            int rSum = prefixSum[n - 1] - lSum;

            int l = 0;
            int r = n - 1;
            
            while (l <= m && m + 1 <= r) {
                // 쿠키 수량이 같을 경우
                if (lSum == rSum) {
                    answer = Math.max(answer, lSum);
                    break;
                }
                
                // 쿠키 수량이 다를 경우
                if (lSum > rSum) {
                    lSum -= cookie[l++];
                } else {
                    rSum -= cookie[r--];
                }
            }
        }
        
        return answer;
    }
}