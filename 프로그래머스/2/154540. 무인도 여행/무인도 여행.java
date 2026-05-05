import java.util.*;

class Solution {
    private final int DIR_SIZE = 4;
    private final int[] DIR_Y = {-1, 0, 1, 0};
    private final int[] DIR_X = {0, 1, 0, -1};
    
    private int yLen;
    private int xLen;
    private int[][] map;
    
        public int[] solution(String[] maps) {
        yLen = maps.length;
        xLen = maps[0].length();
        
        map = new int[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                char c = maps[y].charAt(x);
                map[y][x] = c == 'X' ? 0 : c - '0';
            }
        }
        
        ArrayList<Integer> answerList = new ArrayList<> ();
        
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (map[y][x] == 0 || map[y][x] == -1) continue;
                answerList.add(bfs(y, x));
            }
        }
        
        if (answerList.isEmpty()) return new int[] {-1};
            
        Collections.sort(answerList);
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    private int bfs(int sy, int sx) {
        int sum = map[sy][sx];
        map[sy][sx] = -1;
        
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        que.offer(new int[] {sy, sx});
        
        while (!que.isEmpty()) {
            int[] cue = que.poll();
            int y = cue[0];
            int x = cue[1];
            
            for (int d = 0; d < DIR_SIZE; d++) {
                int ny = y + DIR_Y[d];
                int nx = x + DIR_X[d];
                
                if (ny < 0 || ny == yLen || nx < 0 || nx == xLen) continue;
                if (map[ny][nx] == 0 || map[ny][nx] == -1) continue;
                
                sum += map[ny][nx];
                map[ny][nx] = -1;
                
                que.offer(new int[] {ny ,nx});
            }
        }
        
        return sum;
    }
}