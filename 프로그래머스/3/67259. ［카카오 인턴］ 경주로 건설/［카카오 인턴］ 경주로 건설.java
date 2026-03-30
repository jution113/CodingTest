import java.util.*;

class Solution {
    private final int DIR_SIZE = 4;
    private final int[] DIR_Y = {-1, 0, 1, 0};
    private final int[] DIR_X = {0, 1, 0, -1};
    
    private class Move {
        int price;
        int[] pos;
        int dir;
        
        public Move(int price, int[] pos, int dir) {
            this.price = price;
            this.pos = pos;
            this.dir = dir;
        }
    }
    
    public int solution(int[][] map) {
        int n = map.length;
        int[][][] priceMap = new int[n][n][DIR_SIZE];
        
        // 맵 초기화
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                Arrays.fill(priceMap[y][x], Integer.MAX_VALUE);
            }
        }
        
        priceMap[0][0][0] = 0;
        priceMap[0][0][1] = 0;
        priceMap[0][0][2] = 0;
        priceMap[0][0][3] = 0;
        
        ArrayDeque<Move> que = new ArrayDeque<> ();
        
        if(map[0][1] == 0) {
            que.offer(new Move(100, new int[] {0, 1}, 1));
            priceMap[0][1][1] = 100;
        }
        if(map[1][0] == 0) {
            que.offer(new Move(100, new int[] {1, 0}, 2));
            priceMap[1][0][2] = 100;
        }
        
        while(!que.isEmpty()) {
            Move move = que.poll();
            int y = move.pos[0];
            int x = move.pos[1];
            int p = move.price;
            int dir = move.dir;
                        
            if (y == n -1 && x == n - 1)
                continue;
            
            for(int d = 0; d < DIR_SIZE; d++) {
                int ny = y + DIR_Y[d];
                int nx = x + DIR_X[d];
                
                if (ny < 0 || ny == n || nx < 0 || nx == n)
                    continue;
                if (map[ny][nx] == 1)
                    continue;

                int np = p + 100;
                
                if (((d == 0 || d == 2) && (dir == 1 || dir == 3)) ||
                   ((d == 1 || d == 3) && (dir == 0 || dir == 2))) {
                    np += 500;
                }
                
                if (np >= priceMap[ny][nx][d])
                    continue;
                priceMap[ny][nx][d] = np;
                
                que.offer(new Move(np, new int[] {ny, nx}, d));
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int d = 0; d < DIR_SIZE; d++) {
            answer = Math.min(answer, priceMap[n - 1][n - 1][d]);
        }
        
        return answer;
    }
}