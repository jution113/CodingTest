import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static long dfs(int y, int x) {
        if(y == N - 1 && x == N - 1) return 1;
        if(map[y][x] == 0) return 0;
        if(dp[y][x] != -1) return dp[y][x];

        dp[y][x] = 0;
        int[] dirY = {map[y][x], 0};
        int[] dirX = {0, map[y][x]};

        for(int i = 0; i < 2; i++) {
            int nextY =  dirY[i] + y;
            int nextX =  dirX[i] + x;
            if(nextY < 0 || N <= nextY || nextX < 0 || N <= nextX) continue;
            dp[y][x] += dfs(nextY, nextX);
        }

        return dp[y][x];
    }
}
