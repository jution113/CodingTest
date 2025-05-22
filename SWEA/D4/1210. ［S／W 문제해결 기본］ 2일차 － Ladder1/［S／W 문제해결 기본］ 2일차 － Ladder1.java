import java.io.*;
import java.util.*;

public class Solution {
    static int[][] map = new int[100][100];
    static int y;
    static int x;
    static int[] dirY = {0, 0, -1};
    static int[] dirX = {1, -1, 0};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            sb.append("#").append(tc).append(" ");
            
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    if (n == 2) {
                        y = i;
                        x = j;
                    }
                    map[i][j] = n;
                }
            }

            while (y > 0) {
                for (int i = 0; i < 3; i++) {
                    int nextY = y + dirY[i];
                    int nextX = x + dirX[i];
                    if (nextX >= 0 && nextX < 100 && map[nextY][nextX] == 1) {
                        map[y][x] = 0;
                        y = nextY;
                        x = nextX;
                        continue;
                    }
                }
            }
            sb.append(x).append("\n");
        }
        System.out.print(sb);
    }
}