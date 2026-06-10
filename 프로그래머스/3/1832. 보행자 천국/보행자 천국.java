import java.util.*;

class Solution {
    private final int MOD = 20170805;
    private final int DIR = 2;
    private final int[] DIR_Y = {0, 1};
    private final int[] DIR_X = {1, 0};
    
    private int[][] cityMap;
    private int[][][] memo;
    private int answer;
    private int m;
    private int n;
    
    public int solution(int m, int n, int[][] cityMap) {
        this.cityMap = cityMap;
        memo = new int[m][n][DIR];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++)
                Arrays.fill(memo[r][c], -1);
        }
        this.m = m;;
        this.n = n;
        
        return dfs(0, 0, 0);
    }
    
    private int dfs(int y, int x, int d) {
        if (y == m - 1 && x == n - 1) {
            memo[y][x][d] = 1;
            return memo[y][x][d];
        }
        if (memo[y][x][d] != -1)
            return memo[y][x][d];
        
        memo[y][x][d] = 0;
        
        for (int nd = 0; nd < DIR; nd++) {
            int ny = y + DIR_Y[nd];
            int nx = x + DIR_X[nd];

            if (ny == m || nx == n) continue;
            if (cityMap[ny][nx] == 1) continue;
            if (cityMap[y][x] == 2 && nd != d) continue;
            
            memo[y][x][d] = (memo[y][x][d] + dfs(ny, nx, nd)) % MOD;
        }
        
        return memo[y][x][d];
    }
    
    private void printMap() {
        int[][] map = new int[m][n];
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                map[r][c] += memo[r][c][0]; 
                map[r][c] += memo[r][c][1]; 
            }
        }
        System.out.println("----- ----- -----");
        for (int r = 0; r < m; r++) {
            System.out.println(Arrays.toString(map[r]));
        }
    }
}