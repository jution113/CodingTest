class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int[][] dp = new int[n][4];

        for (int c = 0; c < 4; c++) {
            dp[0][c] = land[0][c];
        }
        
        for (int r = 1; r < n; r++) {
            for (int curC = 0; curC < 4; curC++) {
                for (int prevC = 0; prevC < 4; prevC++) {
                    if (curC == prevC)
                        continue ;
                    dp[r][curC] = Math.max(dp[r][curC], land[r][curC] + dp[r - 1][prevC]);
                    answer = Math.max(answer, dp[r][curC]);
                }
            }
        }

        return answer;
    }
}