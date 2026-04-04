import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] wayMap = new int[n + 1][m + 1];
        wayMap[1][1] = 1;
        for (int[] puddle : puddles) {
            wayMap[puddle[1]][puddle[0]] = -1;
        }
        
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (y == 1 && x == 1) continue;
                if (wayMap[y][x] == -1) continue;
                
                int up = wayMap[y - 1][x] == -1 ? 0 : wayMap[y - 1][x];
                int right = wayMap[y][x - 1] == -1 ? 0 : wayMap[y][x - 1];
                
                wayMap[y][x] = (up + right) %  1000000007;
            }
        }
        
        return wayMap[n][m];
    }
}