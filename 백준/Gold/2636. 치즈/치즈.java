import java.util.*;
import java.io.*;

// 0: 빈공간
// 1: 치즈
// 2. 치즈 외벽

public class Main {
    static int[] yDir = {1, 0, -1, 0};
    static int[] xDir = {0, 1, 0, -1};

    static int[][] map;
    static boolean[][] visited;

    static int row;
    static int col;

    static ArrayList<Integer> removeSizes;
    static int removeSize = 0;
    static int emptySize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];

        for(int y = 0; y < row; y++) {
            st = new StringTokenizer(br.readLine());

            for(int x = 0; x < col; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int remonveCnt = 0;
        removeSizes = new ArrayList<>();

        while(removeSize + emptySize != row * col) {
            visited = new boolean[row][col];
            removeSize = 0;
            emptySize = 0;

            dfs(0, 0);

            removeSizes.add(removeSize);
            remonveCnt++;
        }



        if(removeSize == 0) {
            removeSize = removeSizes.get(remonveCnt - 2);
            remonveCnt = 1;
        }

        sb.append(remonveCnt).append('\n').append(removeSize);

        System.out.print(sb);

    }

    static void dfs(int y, int x) {
        for(int i = 0; i < 4; i++) {
            int nextY = y + yDir[i];
            int nextX = x + xDir[i];

            if(nextY < 0 || row <= nextY || nextX < 0 || col <= nextX) continue;
            if(visited[nextY][nextX]) continue;

            visited[nextY][nextX] = true;

            if(map[nextY][nextX] == 1) {
                map[nextY][nextX] = 0;
                removeSize++;
            } else {
                emptySize++;
                dfs(nextY, nextX);
            }
        }
    }
}