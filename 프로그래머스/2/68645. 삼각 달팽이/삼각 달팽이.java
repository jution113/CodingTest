class Solution {
    int[] dirY = {1, 0, -1};
    int[] dirX = {0, 1, -1};
    
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int row = 0;
        int col = 0;
        int val = 1;
        int dir = 0;
        int size = 0;
        for (int i = 1; i <= n; i++) {
            size += i;
        }
        
        while (val <= size) {
            map[row][col] = val++;
            
            int nextR = row + dirY[dir];
            int nextC = col + dirX[dir];
            
            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || map[nextR][nextC] != 0) {
                dir = (dir + 1) % 3;
            }
            
            row += dirY[dir];
            col += dirX[dir];
        }
        
        int[] answer = new int[size];
        int i = 0;
        outer:
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] == 0)
                    continue outer;
                answer[i++] = map[r][c];
            }
        }
        
        return answer;
    }
}