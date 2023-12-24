import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int l;
    static int r;
    static int[][] map;
    static ArrayList<Position> merged;
    static int sum;

    static final int DIR_CNT = 4;
    static int[] dirY = {1, 0, -1, 0};
    static int[] dirX = {0, 1, 0, -1};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean isMerged = true;

        while(isMerged) {
            isMerged = false;

            boolean[][] visited = new boolean[n][n];
    
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(visited[i][j]) continue;
                    
                    merged = new ArrayList<>();
                    sum = 0;
                    dfs(visited, i, j);
    
                    if(merged.size() == 0) continue; 
    
                    merged.add(new Position(i, j));
                    sum += map[i][j];
                    int newVal = sum / merged.size();
    
                    for(Position pos : merged) map[pos.y][pos.x] = newVal;
    
                    isMerged = true;
                }
            }

            if(isMerged) result++;
        }

        System.out.print(result);
    }

    static void dfs(boolean[][] visited, int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < DIR_CNT; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];

            if(nextY < 0 || n <= nextY || nextX < 0 || n <= nextX) continue;
            if(visited[nextY][nextX]) continue;
            
            int gap = Math.abs(map[y][x] - map[nextY][nextX]);
            if(gap < l || r < gap) continue;

            merged.add(new Position(nextY, nextX));
            sum += map[nextY][nextX];
            dfs(visited, nextY, nextX);
        }
    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}