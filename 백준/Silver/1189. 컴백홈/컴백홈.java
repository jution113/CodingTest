import java.io.*;
import java.util.*;

public class Main {
    static int r;
    static int c;
    static int k;
    static char[][] map;
    static boolean[][] visited;
    static int cnt;

    static final int MAX = 4;
    static int[] dirY = {1, 0, -1, 0};
    static int[] dirX = {0, 1 , 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];

        int startY = r - 1;
        int startX = 0;

        int targetY = 0;
        int targetX = c - 1;

        for(int i = 0; i < r; i++) {
            String line = br.readLine();

            for(int j = 0; j < c; j++) {
                char input = line.charAt(j);
                map[i][j] = input;
                if(input == 'T') visited[i][j] = true;
            }
        }

        if(!visited[startY][startX]) {
            dfs(startY, startX, targetY, targetX, 1, visited);
        }

        System.out.print(cnt);
    }

    static void dfs(int y, int x, int targetY, int targetX, int depth, boolean[][] visitedMap) {
        if(y == targetY && x == targetX) {
            if(depth == k) cnt++;
            return;
        }

        boolean[][] newVisitedMap = copyMap(visitedMap);
        newVisitedMap[y][x] = true;
        
        for(int i = 0; i < MAX; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];
            
            if(nextY < 0 || r <= nextY) continue;
            if(nextX < 0 || c <= nextX) continue;
            if(newVisitedMap[nextY][nextX]) continue;
            dfs(nextY, nextX, targetY, targetX, depth + 1, newVisitedMap);
        }
    }

    static boolean[][] copyMap(boolean[][] src) {
        boolean[][] tmp = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                tmp[i][j] = src[i][j];
            }
        }

        return tmp;
    }
}