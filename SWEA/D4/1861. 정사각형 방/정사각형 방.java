import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] map;
    static int[] dirY = {-1, 0, 1, 0};
    static int[] dirX = {0, 1, 0, -1};
    static int startNum;
    static int curMoveCnt;
    static int maxMoveCnt;

    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];

            for (int y = 1; y <= N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int x = 1; x <= N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            startNum = map[1][1];
            maxMoveCnt = 1;
            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    curMoveCnt = 0;
                    dfs(y, x, 1);
                    if (maxMoveCnt < curMoveCnt) {
                        startNum = map[y][x];
                        maxMoveCnt = curMoveCnt; 
                    } else if (maxMoveCnt == curMoveCnt && map[y][x] < startNum){
                        startNum = map[y][x];
                    }
                }
            }
            sb.append(startNum).append(" ").append(maxMoveCnt).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int y, int x, int moveCnt) {
        for (int i = 0; i < 4; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];

            if (nextY < 1 || nextY > N) continue;
            if (nextX < 1 || nextX > N) continue;
            if (map[nextY][nextX] - map[y][x] != 1) continue;
            
            dfs(nextY, nextX, moveCnt + 1);
            curMoveCnt = Math.max(curMoveCnt, moveCnt + 1);
            break;
        }
    }
}