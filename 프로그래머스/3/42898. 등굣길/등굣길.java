class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        for (int r = 0; r < n; r++) {
            if (dp[r][0] == -1)
                break;
            dp[r][0] = 1;
        }
        
        for (int c = 0; c < m; c++) {
            if (dp[0][c] == -1)
                break;
            dp[0][c] = 1;
        }
        
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                if (dp[r][c] == -1)
                    continue;
                int up = dp[r - 1][c] == -1 ? 0 : dp[r - 1][c];
                int right = dp[r][c - 1] == -1 ? 0 : dp[r][c - 1];
                dp[r][c] = (up + right) % 1000000007;
            }
        }
        
        return dp[n - 1][m - 1];
    }
}