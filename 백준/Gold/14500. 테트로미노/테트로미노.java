import java.util.*;
import java.io.*;

public class Main {
    static final int DEPTH_LIMIT = 4;
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirY = {-1, 0, 1, 0};
    static int[] dirX = {0, 1, 0, -1};
    static int[] extendDirY1 = {-1, -1, 1, 1};
    static int[] extendDirX1 = {-1, 1, 1, -1};
    static int[] extendDirY2 = {-1, 1, 1, -1};
    static int[] extendDirX2 = {1, 1, -1, -1};
    static int maxPoint = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                visited[y][x] = true;
                solve1(y, x, 1, map[y][x]);
                visited[y][x] = false;
                solve2(y, x, map[y][x]);
            }
        }
        System.out.println(maxPoint);
    }

    static void solve1(int y, int x, int depth, int point) {
        if (depth == DEPTH_LIMIT) {
            maxPoint = Math.max(point, maxPoint);
            return ;
        }
        for (int i = 0; i < 4; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];
            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M || visited[nextY][nextX]) continue;
            visited[nextY][nextX] = true;
            solve1(nextY, nextX, depth + 1, point + map[nextY][nextX]);
            visited[nextY][nextX] = false;
        }
    }

    static void solve2(int y, int x, int point) {
        for (int i = 0; i < 4; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];
            int nextY2 = y + extendDirY1[i];
            int nextX2 = x + extendDirX1[i];
            int nextY3 = y + extendDirY2[i];
            int nextX3 = x + extendDirX2[i];
            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) continue;
            if (nextY2 < 0 || nextY2 >= N || nextX2 < 0 || nextX2 >= M) continue;
            if (nextY3 < 0 || nextY3 >= N || nextX3 < 0 || nextX3 >= M) continue;
            maxPoint = Math.max(point + map[nextY][nextX] + map[nextY2][nextX2] + map[nextY3][nextX3], maxPoint);
        }
    }
}
