class Solution {
    public long solution(int n) {
        int[] memo = new int[n + 1];

        if (n <= 2)
            return n;
        
        memo[1] = 1;
        memo[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
            memo[i] %= 1234567;
        }
        return memo[n];
    }
}