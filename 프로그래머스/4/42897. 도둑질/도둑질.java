import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp = new int[money.length];
        
        for (int i = 0; i < dp.length - 1; i++) {
            if (i < 2) {
                dp[i] = money[i];
            } else if (i == 2) {
                dp[i] = dp[i - 2] + money[i];
            } else {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + money[i];
            }
            answer = Math.max(dp[i], answer);
        }
        
        dp = new int[money.length];
        
        for (int i = 1; i < dp.length; i++) {
            if (i < 2) {
                dp[i] = money[i];
            } else if (i == 2) {
                dp[i] = dp[i - 2] + money[i];
            } else {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + money[i];
            }
            answer = Math.max(dp[i], answer);
        }
        
        return answer;
    }
}