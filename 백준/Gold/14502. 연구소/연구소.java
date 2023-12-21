import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[] dirY = {1, 0, -1, 0};
    static int[] dirX = {0, 1, 0, -1};
    static int mapSzie;
    static int[][] simulationMap;
    static int defaultWallCnt = 0;
    static int defaultVirusCnt = 0;
    static int maxSafeZoneCnt = 0;
    static int addedVirusCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        mapSzie = n * m;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());

                if(input == 1) {
                    defaultWallCnt++;
                } else if(input == 2) {
                    defaultVirusCnt++;
                }

                map[i][j] = input;
            }
        }


        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                setWall(y, x, map, 0);
            }
        }

        System.out.print(maxSafeZoneCnt);

    }

    static void setWall(int y, int x, int[][] mapSrc, int setWallCnt) {
        if(setWallCnt == 3) {
            addedVirusCnt = 0;
            simulationMap = copyArray(mapSrc);
    
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(simulationMap[i][j] == 2) virusSimulation(i, j);
                }
            }
    
            int currentSafeZoneCnt = mapSzie - (defaultWallCnt + 3 + defaultVirusCnt + addedVirusCnt);
            if(currentSafeZoneCnt > maxSafeZoneCnt) maxSafeZoneCnt = currentSafeZoneCnt;
            return;
        }

        if(mapSrc[y][x] == 0) {
            int[][] copyMap = copyArray(mapSrc);
            copyMap[y][x] = 1;

            for(int nextY = y; nextY < n; nextY++) {
                for(int nextX = 0; nextX < m; nextX++) {
                    setWall(nextY, nextX, copyMap, setWallCnt + 1);
                }
            }
        }

    }

    static void virusSimulation(int startY, int startX) {
        for(int i = 0; i < dirY.length; i++) {
            int nextY = startY + dirY[i];
            int nextX = startX + dirX[i];

            if(nextY < 0 || n <= nextY) continue;
            if(nextX < 0 || m <= nextX) continue;
            if(simulationMap[nextY][nextX] != 0) continue;
            simulationMap[nextY][nextX] = 2;
            addedVirusCnt++;
            virusSimulation(nextY, nextX);
        }

    }

    static int[][] copyArray(int[][] src) {
        int row = src.length;
        int col = src[0].length;
        int[][] result = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                result[i][j] = src[i][j];
            }
        }

        return result;
    }
}