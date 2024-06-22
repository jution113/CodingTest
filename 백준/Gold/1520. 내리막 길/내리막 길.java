import java.util.*;
import java.io.*;

public class Main {
    static int M;
    static int N;
    static  int[][] map;
    static int[][] dp;
    static final int[] DIR_Y = {1, 0, -1, 0};
    static final int[] DIR_X = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for(int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                dp[r][c] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int r, int c) {
        if(r == M - 1 && c == N - 1) {
            return 1;
        }

        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 0;

        for(int i = 0; i < 4; i++) {
            int nextY = DIR_Y[i] + r;
            int nextX = DIR_X[i] + c;

            if(nextY < 0 || M <= nextY) continue;
            if(nextX < 0 || N <= nextX) continue;
            if(map[r][c] <= map[nextY][nextX]) continue;

            dp[r][c] += dfs(nextY, nextX);
        }

        return dp[r][c];
    }
}