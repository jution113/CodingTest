import java.util.*;

class Solution {
    private final int DIR_SIZE = 4;
    private final int[] DIR_Y = {-1, 0, 1, 0};
    private final int[] DIR_X = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int minMove = Integer.MAX_VALUE;
        boolean[][] visit = new boolean[n][m];
        
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        que.offer(new int[] {0, 0, 1});
        visit[0][0] = true;
        
        while (!que.isEmpty()) {
            int[] node = que.poll();
            int y = node[0];
            int x = node[1];
            int move = node[2];
            
            if (y == n - 1 && x == m - 1) 
                return move;
            
            for (int d = 0; d < DIR_SIZE; d++) {
                int ny = y + DIR_Y[d];
                int nx = x + DIR_X[d];
                
                if (ny < 0 || ny == n || nx < 0 || nx == m)
                    continue;
                if (visit[ny][nx] || maps[ny][nx] != 1)
                    continue;
                
                visit[ny][nx] = true;
                que.offer(new int[] {ny, nx, move + 1});
            }
        }
        
        return -1;
    }
}