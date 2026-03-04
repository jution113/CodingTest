class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        
        for (int[] puddle : puddles) {
            int r = puddle[1];
            int c = puddle[0];
            dp[r][c] = -1;
        }
        
        for (int r = 1; r <= n; r++) {
            if (dp[r][1] == -1) break;
                dp[r][1] = 1;
        }
        
        for (int c = 1; c <= m; c++) {
            if (dp[1][c] == -1) break;
                dp[1][c] = 1;
        }
        
        for (int r = 2; r <= n; r++) {
            for (int c = 2; c <= m; c++) {
                if (dp[r][c] == -1) continue;
                
                int left = dp[r][c - 1] == -1 ? 0 : dp[r][c - 1];
                int up = dp[r - 1][c] == -1 ? 0 : dp[r - 1][c];
                dp[r][c] = (left + up) % 1000000007;
            }
        }
        
        int answer = dp[n][m];
        return answer;
    }
}