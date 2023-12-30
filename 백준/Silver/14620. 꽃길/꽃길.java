import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static final int DIR_CNT = 4;
    static int[] dirY = {1, 0, -1, 0};
    static int[] dirX = {0, 1, 0, -1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                boolean[][] visited = new boolean[n][n];
                find(i, j, visited, 0, 0);
            }
        }

        System.out.print(result);
    }

    static void find(int y, int x, boolean[][] visited, int cnt, int totalSum) {
        if(visited[y][x] || cnt > 2) {
            if(cnt > 2) {
                if(totalSum < result) result = totalSum;
            }
            return;
        }
        
        boolean isPlace = true;
        
        for(int i = 0; i < DIR_CNT; i++) {
            if(visited[y + dirY[i]][x + dirX[i]]) {
                isPlace = false;
                break;
            }
        }
        
        if(isPlace) {
            boolean[][] newVisited = copyArr(visited);
            int sum = 0;
            newVisited[y][x] = true;
            sum += map[y][x];
            for(int i = 0; i < DIR_CNT; i++) {
                newVisited[y + dirY[i]][x + dirX[i]] = true;
                sum += map[y + dirY[i]][x + dirX[i]];
            }

            for(int i = y; i < n - 1; i++) {
                for(int j = 1; j < n - 1; j++) {
                    find(i, j, newVisited, cnt + 1, totalSum + sum);
                }
            }
        }
    }

    static boolean[][] copyArr(boolean[][] src) {
        boolean[][] tmp = new boolean[src.length][src.length];

        for(int i = 0; i < src.length; i++) {
            for(int j = 0; j < src.length; j++) {
                tmp[i][j] = src[i][j];
            }
        }

        return tmp;
    }
}