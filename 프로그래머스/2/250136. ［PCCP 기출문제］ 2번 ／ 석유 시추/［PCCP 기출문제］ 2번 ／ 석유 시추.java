import java.util.*;

class Solution {
    private final int DIR_SIZE = 4;
    private final int[] DIR_Y = {-1, 0, 1, 0};
    private final int[] DIR_X = {0, 1, 0, -1};
    
    private int yLen;
    private int xLen;
    private int[][] land;
    private boolean[][] visitMap;
    private HashMap<Integer, Integer> oilCntById = new HashMap<> ();
    
    public int solution(int[][] land) {
        yLen = land.length;
        xLen = land[0].length;
        this.land = land;
        visitMap = new boolean[yLen][xLen];
        
        int id = 2;
        
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (land[y][x] != 1) continue;
                bfs(id, new int[] {y, x});
                id++;
            }
        }
        
        int maxOilCnt = 0;
        
        for (int x = 0; x < xLen; x++) {
            HashSet<Integer> visit = new HashSet<> ();
            int oilCnt = 0;
            
            for (int y = 0; y < yLen; y++) {
                if (land[y][x] == 0) continue;
                
                id = land[y][x];
                if (!visit.contains(id)) {
                    visit.add(id);
                    oilCnt += oilCntById.get(id);
                }
            }
            
            maxOilCnt = Math.max(maxOilCnt, oilCnt);
        }
        
        return maxOilCnt;
    }
    
    private void bfs(int id, int[] start) {
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        que.offer(start);
        
        visitMap[start[0]][start[1]] = true;
        
        
        int oilCnt = 1;
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int y = cur[0];
            int x = cur[1];
            land[y][x] = id;
            
            for (int d = 0; d < DIR_SIZE; d++) {
                int ny = y + DIR_Y[d];
                int nx = x + DIR_X[d];
                
                if (ny < 0 || ny == yLen || nx < 0 || nx == xLen) continue;
                if (visitMap[ny][nx] || land[ny][nx] != 1) continue;

                visitMap[ny][nx] = true;
                
                que.offer(new int[] {ny, nx});
                oilCnt++;
            }
        }
        
        oilCntById.put(id, oilCntById.getOrDefault(id, 0) + oilCnt);
    }
}