import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int[][] memo = new int[money.length + 1][n + 1];
        
        for (int j = 1; j <= n; j++) {
            if (j % money[0] == 0) memo[1][j] = 1;
        }
        
        for (int i = 2; i <= money.length; i++) {
            int m = money[i - 1];
            
            for (int j = 1; j <= n; j++) {
                if (j < m) {
                    memo[i][j] = memo[i - 1][j];
                } else if (j == m) {
                    memo[i][j] =  memo[i - 1][j] + 1;
                } else {
                    memo[i][j] = memo[i - 1][j] + memo[i][j - m];
                }
                
                memo[i][j] %= 1000000007;
            }
        }
        
//         for (int i = 0; i <= money.length; i++) {
//             System.out.println(Arrays.toString(memo[i]));
//         }
        
        int answer = memo[money.length][n];
        return answer;
    }
}