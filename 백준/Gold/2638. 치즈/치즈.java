import java.io.*;
import java.util.*;

public class Main {
    private static final int DIR_SIZE = 4;
    private static final int[] DIR_Y = {-1, 0, 1, 0};
    private static final int[] DIR_X = {0, 1, 0, -1};
    
    private static int yLen;
    private static int xLen;
    private static int[][] map;
    
    public static void main(String[] artgs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());
        map = new int[yLen][xLen];
        
        for (int y = 0; y < yLen; y++) {
            st = new StringTokenizer(br.readLine());
            
            for (int x = 0; x < xLen; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        
        int time = 0;
        while (isExistCheese()) {
            bfs();
            time++;
        }
        
        System.out.println(time);
    }
    
    private static boolean isExistCheese() {
        int cheese = 0; 
        
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (map[y][x] >= 1) {
                    if (map[y][x] >= 3) {
                        map[y][x] = 0;
                    } else {
                        map[y][x] = 1;
                        cheese++;
                    }
                }
            }
        }
        
        return cheese == 0 ? false : true;
    }
    
    private static void bfs() {
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        boolean[][] visit = new boolean[yLen][xLen];
        
        // y축 외부 노출면 설정
        for (int y = 0; y < yLen; y++) {
            if (map[y][0] == 0) {
                que.offer(new int[] {y, 0});
                visit[y][0] = true;
            }
            if (map[y][xLen - 1] == 0) {
                que.offer(new int[] {y, xLen - 1});
                visit[y][xLen - 1] = true;
            }
        }
        
        // x축 외부 노출면 설정
        for (int x = 0; x < xLen; x++) {
            if (map[0][x] == 0) {
                que.offer(new int[] {0, x});
                visit[0][x] = true;
            }
            if (map[yLen - 1][x] == 0) {
                que.offer(new int[] {yLen - 1, x});
                visit[yLen - 1][x] = true;
            }
        }
        
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            int y = pos[0];
            int x = pos[1];
            
            for (int dir = 0; dir < DIR_SIZE; dir++) {
                int ny = y + DIR_Y[dir];
                int nx = x + DIR_X[dir];
                
                if (ny < 0 || ny == yLen || nx < 0 || nx == xLen || visit[ny][nx])
                    continue;
                // 0이 아니라면 접촉면만 카운팅
                if (map[ny][nx] != 0) {
                    map[ny][nx]++;
                    continue;
                }
                que.offer(new int[] {ny, nx});
                visit[ny][nx] = true;
            }
        }
    }
}