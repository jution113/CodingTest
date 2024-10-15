import java.util.*;
import java.io.*;

class Solution
{
    static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N + 1][N + 1];
            init(N, map);
            int[] colorCount = {0, 2, 2};

            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());

                map[y][x] = color;
                colorCount[color]++;
                int findColor = color == 1 ? 2: 1;

                for(int dir = 0; dir < 8; dir++) {
                    Queue<int[]> pos = new LinkedList<> ();
                    int nextY = y;
                    int nextX = x;
                    while(true) {
                        nextY += dirY[dir];
                        nextX += dirX[dir];
                        if(nextY < 1 || N < nextY || nextX < 1 ||  N < nextX) break;
                        if(map[nextY][nextX] == color) {
                            while(!pos.isEmpty()) {
                                int[] findColorPos = pos.poll();
                                map[findColorPos[0]][findColorPos[1]] = color;
                                colorCount[color]++;
                                colorCount[findColor]--;
                            }
                            break;
                        } else if(map[nextY][nextX] == findColor) {
                            pos.offer(new int[] {nextY , nextX});
                        } else {
                            break;
                        }
                    }
                }
            }
            sb.append(colorCount[1]).append(" ").append(colorCount[2]).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void init(int mapSize, int[][] map) {
        int halfSize = mapSize / 2;
        map[halfSize][halfSize] = 2;
        map[halfSize][halfSize + 1] = 1;
        map[halfSize + 1][halfSize] = 1;
        map[halfSize + 1][halfSize + 1] = 2;
    }
}