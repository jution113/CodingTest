import java.util.*;

class Solution {
    private final int MAP_SIZE = 100;
    private final int DIR_SIZE = 4;
    private final int[] DIR_Y = {-1, 0, 1, 0};
    private final int[] DIR_X = {0, 1, 0, -1};
    private int[][] map;
    
    private class MoveInfo {
        int moveCnt;
        int[] pos;
        
        public MoveInfo(int moveCnt, int[] pos) {
            this.moveCnt = moveCnt;
            this.pos = pos;
        }
    }
    
    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        map = new int[MAP_SIZE + 1][MAP_SIZE + 1];
        
        for (int[] rectangle : rectangles) {
            paintOutter(rectangle);
        }
        
        for (int[] rectangle : rectangles) {
            paintInner(rectangle);
        }
        
        // for (int[] line : map) {
        //     System.out.println(Arrays.toString(line));
        // }
        
        return bfs(new int[] {characterY * 2, characterX * 2}, new int[] {itemY * 2, itemX * 2});
    }
    
    private void paintOutter(int[] rectangle) {
        int sy = rectangle[1] * 2;
        int sx = rectangle[0] * 2;
        int ey = rectangle[3] * 2;
        int ex = rectangle[2] * 2;
        
        for (int y = sy; y <= ey; y++) {
            map[y][sx] = 1;
            map[y][ex] = 1;
        }
        
        for (int x = sx; x <= ex; x++) {
            map[sy][x] = 1;
            map[ey][x] = 1;
        }
    }
    
    private void paintInner(int[] rectangle) {
        int sy = rectangle[1] * 2;
        int sx = rectangle[0] * 2;
        int ey = rectangle[3] * 2;
        int ex = rectangle[2] * 2;
        
        for (int y = sy + 1; y < ey; y++) {
            for (int x = sx + 1; x < ex; x++) {
                map[y][x] = 0;
            }
        }
    }
    
    private int bfs(int[] startPos, int[] endPos) {
        int answer = 0;
        boolean[][] visit = new boolean[MAP_SIZE + 1][MAP_SIZE + 1];
        
        ArrayDeque<MoveInfo> que = new ArrayDeque<> ();
        que.offer(new MoveInfo(0, startPos));
        
        while(!que.isEmpty()) {
            MoveInfo info = que.poll();
            int y = info.pos[0];
            int x = info.pos[1];
            visit[y][x] = true;
            
            if (y == endPos[0] && x == endPos[1]) {
                answer = info.moveCnt;
                break;
            }
            
            for (int d = 0; d < DIR_SIZE; d++) {
                int ny = y + DIR_Y[d];
                int nx = x + DIR_X[d];
                
                if (ny < 0 || ny > MAP_SIZE || nx < 0 || nx > MAP_SIZE)
                    continue;
                if (visit[ny][nx] || map[ny][nx] == 0)
                    continue;
                
                que.offer(new MoveInfo(info.moveCnt + 1, new int[] {ny, nx}));   
            }
        }
        
        return answer / 2;
    }
}