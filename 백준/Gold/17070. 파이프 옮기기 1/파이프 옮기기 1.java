import java.io.*;
import java.util.*;

public class Main {
    private static final int DIR_SIZE = 3;
    private static final int[] DIR_Y = {0, 1, 1};
    private static final int[] DIR_X = {1, 1, 0};
    
    private static int n;
    private static int[][] map;
    private static int[][][] methodMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        
        // [0] = y, [1] = x, [2] = dir
        methodMap = new int[n][n][3];

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                Arrays.fill(methodMap[r][c], - 1);
            }
        }
        
        System.out.println(dfs(0, 1, 0));
    }
    
    private static int dfs(int y, int x, int dir) {
        // 도착 검사
        if (y == n - 1 && x == n - 1) {
            return 1;
        }
        
        if (methodMap[y][x][dir] != -1) {
            return methodMap[y][x][dir];
        }
        
        methodMap[y][x][dir] = 0;
        
        for (int nextDir = 0; nextDir < DIR_SIZE; nextDir++) {
            // 파이프: 가로, 세로 조건 검사
            if ((dir == 0 && nextDir == 2) || (dir == 2 && nextDir == 0))
                continue;
            
            int ny = y + DIR_Y[nextDir];
            int nx = x + DIR_X[nextDir];
            
            // 파이프: 공통 조건 검사
            if (ny == n || nx == n || map[ny][nx] == 1)
                continue;
            
            // 파이프: 대각선 조건 검사
           if (nextDir == 1 && (map[ny - 1][nx] != 0 || map[ny][nx - 1] != 0))
               continue;
            
            methodMap[y][x][dir] += dfs(ny, nx, nextDir);
        }
        
        return methodMap[y][x][dir];
    }
}