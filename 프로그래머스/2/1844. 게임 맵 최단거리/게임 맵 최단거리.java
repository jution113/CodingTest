import java.util.*;

class Solution {
    static int yLen = 0;
    static int xLen = 0;
    static int[] yDir = {1, 0, -1, 0};
    static int[] xDir = {0, 1, 0, -1};
    static int[][] mapsCopy;
    static boolean[][] isVisited;
    
    public int solution(int[][] maps) {
        xLen = maps[0].length;
        yLen = maps.length;
        mapsCopy = maps;
        isVisited = new boolean[yLen][xLen];
        return bfs();
    }
    
    private int bfs() {
        Queue<Move> que = new ArrayDeque<> ();
        que.offer(new Move(0, 0, 0));
        isVisited[0][0] = true;
        
        while (!que.isEmpty()) {
            Move m = que.poll();
            m.cnt++;
            
            if (m.y == yLen - 1 && m.x == xLen - 1)
                return m.cnt;
            
            for (int i = 0; i < 4; i++) {
                int nextY = m.y + yDir[i];
                int nextX = m.x + xDir[i];
                
                if (nextX >= 0 && nextX < xLen && 
                    nextY >= 0 && nextY < yLen &&
                    mapsCopy[nextY][nextX] == 1 &&
                    !isVisited[nextY][nextX]) {
                    isVisited[nextY][nextX] = true;
                    que.offer(new Move(nextY, nextX, m.cnt));
                }
            }
        }
        return -1;
    }
    
    private class Move {
        int y;
        int x;
        int cnt;
        
        public Move(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}