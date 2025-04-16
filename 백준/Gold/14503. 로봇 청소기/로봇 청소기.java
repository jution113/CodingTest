import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int dir;
    static int[] dirY = {-1, 0, 1, 0};
    static int[] dirX = {0, 1, 0, -1};
    static int cleanCnt = 0;

    public static boolean validateNextTile(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];
            if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && map[nextY][nextX] == 0) {
                return true;
            }
        }
        return false;
    }
    
    public static void dfs(int y, int x) {
        if (map[y][x] == 0) {
            map[y][x] = 2;
            cleanCnt++;
        }
        
        if (validateNextTile(y, x)) {
            int nextDir = dir;
            
            for (int i = 0; i < 4; i++) {
                nextDir = (nextDir + 3) % 4;
                int nextY = y + dirY[nextDir];
                int nextX = x + dirX[nextDir];
                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && map[nextY][nextX] == 0) {
                    dir = nextDir;
                    dfs(nextY, nextX);
                    return ;
                }
            }
        } else {
            int backDir = (dir + 2) % 4;
            int backY = y + dirY[backDir];
            int backX = x + dirX[backDir];
            
            if (backY >= 0 && backY < N && backX >= 0 && backX < M && map[backY][backX] != 1)
                dfs(backY, backX);
            else {
                System.out.println(cleanCnt);
                System.exit(0);    
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int initY = Integer.parseInt(st.nextToken());
        int initX = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(initY, initX);
        System.out.println(cleanCnt);
    }
}
