import java.io.*;
import java.util.*;

public class Main {
    private static final int DIR_SIZE = 4;
    private static final int[] DIR_Y = {-1, 0, 1, 0};
    private static final int[] DIR_X = {0, 1, 0, -1};
    private static int n;
    private static int m;
    private static int[][] map;
    
    private static class MoveInfo {
        int[] pos;
        int moveCntSum;
        boolean isUsed;
        
        public MoveInfo(int[] pos, int moveCntSum, boolean isUsed) {
            this.pos = pos;
            this.moveCntSum = moveCntSum;
            this.isUsed = isUsed;
        }
    }
    
    private static int bfs(MoveInfo start) {
        // 3차원: 0(벽을 부수지 않은 경우), 1(벽을 부순 경우)
        boolean[][][] isVisit = new boolean[n][m][2];
        
        ArrayDeque<MoveInfo> que = new ArrayDeque<> ();
        que.offer(start);
        isVisit[0][0][0] = true;
        
        while (!que.isEmpty()) {
            MoveInfo moveInfo = que.poll();
            int y = moveInfo.pos[0];
            int x = moveInfo.pos[1];
            
            if (y == n - 1 && x == m - 1) {
                return moveInfo.moveCntSum;
            }
            
            for (int dir = 0; dir < DIR_SIZE; dir++) {
                int ny = y + DIR_Y[dir];
                int nx = x + DIR_X[dir];
                boolean isUsed = moveInfo.isUsed;
                
                if (ny < 0 || ny == n || nx < 0 || nx == m) {
                    continue;
                }
                
                if (isUsed) {
                    if (isVisit[ny][nx][1] || map[ny][nx] == 1) continue;
                    isVisit[ny][nx][1] = true;
                } else {
                    if (isVisit[ny][nx][0]) continue;
                    if (map[ny][nx] == 1) isUsed = true;
                    isVisit[ny][nx][0] = true;
                }
                
                que.offer(new MoveInfo(new int[] {ny, nx}, moveInfo.moveCntSum + 1, isUsed));
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        for (int y = 0; y < n; y++) {
            String line = br.readLine();
            
            for (int x = 0; x < m; x++) {
                map[y][x] = line.charAt(x) - '0';
            }
        }
        
        System.out.println(bfs(new MoveInfo(new int[] {0, 0}, 1, false)));
    }
}