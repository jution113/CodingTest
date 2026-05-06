class Solution {
    public int solution(int [][]board) {
        int yLen = board.length;
        int xLen = board[0].length;
        
        int[][] memo = new int[yLen + 1][xLen + 1];
        int answer = 0;
        
        for (int y = 1; y <= yLen; y++) {
            for (int x = 1; x <= xLen; x++) {
                if (board[y - 1][x - 1] == 0) continue;
                int len = Math.min(memo[y - 1][x - 1], Math.min(memo[y - 1][x], memo[y][x - 1]));
                memo[y][x] = len + 1;
                answer = Math.max(answer, memo[y][x]);
            }
        }
        
        return answer * answer;
    }
}