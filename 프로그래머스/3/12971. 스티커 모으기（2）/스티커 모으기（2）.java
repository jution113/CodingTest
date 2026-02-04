class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        int answer = Integer.MIN_VALUE;
        
        if (n == 1)
            return sticker[0];
        
        for (int i = 0; i < n - 1; i++) {
            int val = i - 3 >= 0 ? dp[i - 3] : 0;
            int val2 = i - 2 >= 0 ? dp[i - 2] : 0;
            
            dp[i] = Math.max(val, val2) + sticker[i];
            answer = Math.max(answer, dp[i]);
        }
        
        for (int i = 1; i < n; i++) {
            int val = i - 3 >= 1 ? dp2[i - 3] : 0;
            int val2 = i - 2 >= 1 ? dp2[i - 2] : 0;
            
            dp2[i] = Math.max(val, val2) + sticker[i];
            answer = Math.max(answer, dp2[i]);
        }
        
        return answer;
    }
}