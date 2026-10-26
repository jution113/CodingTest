import java.util.*;
import java.io.*;

public class Solution {
    private static final int DIR_LEN = 4;
    private static final int[] DIR_Y = {-1, 0, 1, 0};
    private static final int[] DIR_X = {0, 1, 0, -1};
    
    private static BufferedReader br;
    private static int N;
    private static int[][] map;
    private static int[][] costMap;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            initMap();
            initCostMap();
            bfs(new int[] {0, 0, 0});
            sb.append("#" + t + " " + costMap[N - 1][N - 1] + "\n");
        }
        System.out.print(sb.toString());
    }
    
    private static void initMap() throws IOException {
        map = new int[N][N];
        String input = "init";
        
        for (int y = 0; y < N; y++) {
            input = br.readLine();
            for (int x = 0; x < N; x++) map[y][x] = input.charAt(x) - '0';
        }
    }
    
    private static void initCostMap() {
        costMap = new int[N][N];
        
        for (int i = 0; i < N; i++) Arrays.fill(costMap[i], Integer.MAX_VALUE);
        costMap[0][0] = 0;
    }

    private static void bfs(int[] start) {
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        que.offer(start);

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int y = cur[0];
            int x = cur[1];
            int cost = cur[2];

            for (int dir = 0; dir < DIR_LEN; dir++) {
                int nextY = y + DIR_Y[dir];
                int nextX = x + DIR_X[dir];

                if (nextY < 0 || nextY >= N || nextX < 0  || nextX >= N)
                    continue;
                
                int nextCost = cost + map[nextY][nextX];
                
                if (nextCost >= costMap[nextY][nextX])
                    continue;
                costMap[nextY][nextX] = nextCost;
                que.offer(new int[] {nextY, nextX, nextCost});
            }
        }
    }
}
