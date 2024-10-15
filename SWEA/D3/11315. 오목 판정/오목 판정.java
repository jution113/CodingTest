import java.util.*;
import java.io.*;

class Solution
{
    static int[] dirY = {-1, 1, 1, -1};
    static int[] dirX = {1, 1, -1, -1};

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine());
            String[][] map = new String[N][N];
            int[] rowCount = new int[N];
            int[] colCount = new int[N];
            String result = "NO";

            //  가로, 세로 검사
            for(int i = 0; i < N; i++) {
                String[] input = br.readLine().split("");
                for(int j = 0; j < N; j++) {
                    map[i][j] = input[j];
                    if(map[i][j].equals("o")) {
                        rowCount[i]++;
                        colCount[j]++;
                        if(rowCount[i] >= 5 || colCount[j] >= 5) result = "YES";
                    } else {
                        rowCount[i] = 0;
                        colCount[j] = 0;
                    }
                }
            }

            // 대각선 검사
            if(result.equals("NO")) {
                check:
                for(int y = 0; y < N; y++) {
                    for(int x = 0; x < N; x++) {
                        if(map[y][x].equals("o")) {
                            for(int dir = 0; dir < 4; dir++) {
                                int nextY = y + dirY[dir];
                                int nextX = x + dirX[dir];
                                int count = 1;

                                while(0 <= nextY && nextY <N && 0 <= nextX && nextX < N && count < 5 && map[nextY][nextX].equals("o")) {
                                    count++;
                                    nextY += dirY[dir];
                                    nextX += dirX[dir];
                                }
                                if(count >= 5) {
                                    result = "YES";
                                    break check;
                                }
                            }
                        }
                    }
                }
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
    }
}
