import java.util.*;

class Solution {
    private final int MOVE_LIMIT = 2;
    private final int DIR_SIZE = 4;
    private final int[] DIR_Y = {-1, 0, 1, 0};
    private final int[] DIR_X = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        outer:
        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            int yLen = place.length;
            int xLen = place[0].length();
            char[][] map = new char[yLen][xLen];
            ArrayList<int[]> startList = new ArrayList<> ();
            
            for (int y = 0; y < yLen; y++) {
                for (int x = 0; x < xLen; x++) {
                    map[y][x] = place[y].charAt(x);
                    if (map[y][x] == 'P') startList.add(new int[] {y, x});
                }
            }
                        
            for (int[] start : startList) {
                if (bfs(start, yLen, xLen, map) == 0) {
                    answer[i] = 0;
                    continue outer;
                }
            }
            answer[i] = 1;
        }
        return answer;
    }
    
    private int bfs(int[] start, int yLen, int xLen, char[][] map) {
        // [0] = y, [1] = x, [2] = move
        int sy = start[0];
        int sx = start[1];
        
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        que.offer(new int[] {sy, sx, 0});
        
        boolean[][] visit = new boolean[yLen][xLen];
        visit[sy][sx] = true;
        
        while (!que.isEmpty()) {
            int[] node = que.poll();
            int y = node[0];
            int x = node[1];
            int move = node[2];
            
            for (int d = 0; d < DIR_SIZE; d++) {
                int ny = y + DIR_Y[d];
                int nx = x + DIR_X[d];
                
                if (ny < 0 || ny == yLen || nx < 0 || nx == xLen) continue;
                if (visit[ny][nx] || map[ny][nx] == 'X' || move + 1 > MOVE_LIMIT) continue;
                if (map[ny][nx] == 'P') return 0;
                
                que.offer(new int[] {ny, nx, move + 1});
                visit[ny][nx] = true;
            }
        }
        
        return 1;
    }
}