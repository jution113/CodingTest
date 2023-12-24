import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] map;
    static int row;
    static int col;

    static int maxHour = 0;

    static final int DIR_CNT = 4;
    static int[] dirY = {1, 0, -1, 0};
    static int[] dirX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            String line = br.readLine();

            for(int j = 0; j < col; j++) map[i][j] = line.charAt(j) == 'L' ? true : false;
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(map[i][j]) {
                    bfs(i, j, 0);
                }
            }
        }

        System.out.print(maxHour);
    }

    static class MoveInfo {
        int row;
        int col;
        int hour;

        public MoveInfo(int row, int col, int hour) {
            this.row = row;
            this.col = col;
            this.hour = hour;
        }
    }

    static void bfs(int startX, int startY, int startHour) {
        Queue<MoveInfo> que = new LinkedList<>();
        que.add(new MoveInfo(startX, startY, startHour));

        boolean[][] visited = new boolean[row][col];
        visited[startX][startY] = true;

        while(!que.isEmpty()) {
            MoveInfo info = que.poll();
            
            for(int i = 0; i < DIR_CNT; i++) {
                int nextY = info.row + dirY[i];
                int nextX = info.col + dirX[i];
                
                if(nextY < 0 || row <= nextY) continue;
                if(nextX < 0 || col <= nextX) continue;
                if(!map[nextY][nextX]) continue;
                if(visited[nextY][nextX]) continue;
                visited[nextY][nextX] = true;
                que.add(new MoveInfo(nextY, nextX, info.hour + 1));
                if(info.hour + 1 > maxHour) maxHour = info.hour + 1;
            }
        }
    }
}