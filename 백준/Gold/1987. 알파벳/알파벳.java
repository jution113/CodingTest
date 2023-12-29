import java.io.*;
import java.util.*;

public class Main {
    static int[] dirY = {1, 0, -1, 0};
    static int[] dirX = {0, 1, 0, -1};

    static int r;
    static int c;
    static int[][] map;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[91]; // ascii Z = 90이기 때문에 91로 초기화

        for(int i = 0; i < r; i++) {
            String line = br.readLine();

            for(int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j) + 0;
            }
        }

        dfs(new Position(0, 0), 1, visited);

        System.out.print(result);
    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void dfs(Position pos, int depth, boolean[] visited) {
        
        
        if(result < depth) result = depth;
        boolean[] copyVisited = copyArr(visited);
        copyVisited[map[pos.y][pos.x]] = true;;
        

        for(int i = 0; i < 4; i++) {
            int nextY = pos.y + dirY[i];
            int nextX = pos.x + dirX[i];

            if(nextY < 0 || r <= nextY) continue;
            if(nextX < 0 || c <= nextX) continue;
            if(copyVisited[map[nextY][nextX]]) continue;
            dfs(new Position(nextY, nextX), depth + 1, copyVisited);
        }
    }

    static boolean[] copyArr(boolean[] src) {
        boolean[] tmp = new boolean[src.length];

        for(int i = 0; i < src.length; i++) {
            tmp[i] = src[i];
        }

        return tmp;
    }
}