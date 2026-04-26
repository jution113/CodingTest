import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        int[] arr = new int[n];
        int[] arr2 = new int[n];

        int sign = 1;
        int sign2 = -1;
        
        for (int i = 0; i < n; i++) {
            arr[i] = sequence[i] * sign;
            arr2[i] = sequence[i] * sign2;
            sign *= -1;
            sign2 *= -1;
        }
        
        long[] memo = new long[n];
        long[] memo2 = new long[n];
        memo[0] = arr[0];
        memo2[0] = arr2[0];
        
        long answer = Math.max(memo[0], memo2[0]);
        
        for (int i = 1; i < n; i++) {
            memo[i] = Math.max(memo[i - 1] + arr[i], arr[i]);
            memo2[i] = Math.max(memo2[i - 1] + arr2[i], arr2[i]);
            answer = Math.max(answer, Math.max(memo[i], memo2[i]));
        }
        
        return answer;
    }
}