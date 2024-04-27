import java.io.*;
import java.util.*;

public class Main {
    static int[] DIR_R = {-1, 0, 1, 0};
    static int[] DIR_C = {0, 1, 0, -1};
    static int dirIdx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        boolean[][] visited = new boolean[N + 1][N + 1];
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }
        int L = Integer.parseInt(br.readLine());
        String[] moveInfo = new String[10001];
        for(int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int moveTime = Integer.parseInt(st.nextToken());
            String moveDir = st.nextToken();
            moveInfo[moveTime] = moveDir;
        }

        int time = 0;
        int snakeLength = 1;
        Queue<Position> snake = new LinkedList<>();
        Position headPos = new Position(1, 1);
        snake.offer(new Position(1, 1));

        while(true) {
            visited[headPos.r][headPos.c] = true;

            if(moveInfo[time] != null) {
                if(moveInfo[time].equals("D")) {
                    dirIdx = dirIdx + 1 > 3 ? 0 : dirIdx + 1;
                } else {
                    dirIdx = dirIdx - 1 < 0 ? 3 : dirIdx - 1;
                }
            }

            int nextRPos = headPos.r + DIR_R[dirIdx];
            int nextCPos = headPos.c + DIR_C[dirIdx];

            if(nextRPos < 1 || N < nextRPos) break;
            if(nextCPos < 1 || N < nextCPos) break;
            if(visited[nextRPos][nextCPos]) break;

            headPos.r = nextRPos;
            headPos.c = nextCPos;
            snake.offer(new Position(headPos.r, headPos.c));

            if(map[headPos.r][headPos.c] == 1) {
                map[headPos.r][headPos.c] = 0;
                snakeLength++;
            } else {
                while(snakeLength < snake.size()) {
                    Position tail = snake.poll();
                    visited[tail.r][tail.c] = false;
                }
            }

            time++;
        }

        System.out.println(time + 1);
    }

    static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
