import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[] dirY = {-1, 0, 1, 0};
    static int[] dirX = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Queue<Point> bufferQueue1 = new LinkedList<> ();
        Queue<Point> bufferQueue2 = new LinkedList<> ();
        int targetCnt = 0;
        int resCnt = 0;

        // map setting
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                int num = Integer.parseInt(st.nextToken());
                map[y][x] = num;
                if (num == 1) {
                    bufferQueue1.offer(new Point(y, x));
                } else if (num == 0) targetCnt++;
            }
        }

        // spread
        while (true) {
            Queue<Point> fullQueue = bufferQueue1.isEmpty() ? bufferQueue2 : bufferQueue1;
            Queue<Point> emptyQueue = bufferQueue1.isEmpty() ? bufferQueue1 : bufferQueue2;

            while (!fullQueue.isEmpty()) {
                Point point = fullQueue.poll();
                int y = point.y;
                int x = point.x;

                for (int i = 0; i < 4; i ++) {
                    int nextY = y + dirY[i];
                    int nextX = x + dirX[i];
                    if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && map[nextY][nextX] == 0) {
                        map[nextY][nextX] = 1;
                        targetCnt--;
                        emptyQueue.offer(new Point(nextY, nextX));
                    }
                }
            }
            if (emptyQueue.isEmpty()) break;
            resCnt++;
        }

        if (targetCnt > 0) resCnt = -1;
        System.out.print(resCnt);
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
