import java.io.*;
import java.util.*;

public class Main {
    static final int[] DIR_Y = {1, 0, -1, 0};
    static final int[] DIR_X = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;
    static RotateRange[] rotateRanges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        boolean[] visited = new boolean[K];
        rotateRanges = new RotateRange[K];

        for(int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());

            for(int c = 1; c <= M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            rotateRanges[i] = new RotateRange(r, c, s);
        }

        permutation(0, K, map, visited);

        System.out.println(min);
    }

    static void permutation(int curDepth, int maxDepth, int[][] map, boolean[] visited) {
        if(curDepth == maxDepth) {
            minCheck(map);
            return;
        }

        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int[][] copiedMap = copyMap(map);
                RotateRange rotateRange = rotateRanges[i];
                rotateMap(copiedMap, rotateRange.startR, rotateRange.startC, rotateRange.endR, rotateRange.endC);
                permutation(curDepth + 1, maxDepth, copiedMap, visited);
                visited[i] = false;
            }
        }
    }

    static void rotateMap(int[][] map, int startR, int startC, int endR, int endC) {
        int rLength = endR - startR + 1;
        int cLength = endC - startC + 1;

        int r = startR;
        int c = startC;
        int dirIdx = 0;
        int startNum = map[startR][startC];

        while(r != startR || c != startC + 1) {
            int nextR = r + DIR_Y[dirIdx];
            int nextC = c + DIR_X[dirIdx];

            if(!(startR <= nextR && nextR <= endR && startC <= nextC && nextC <= endC)) {
                dirIdx++;
                nextR = r + DIR_Y[dirIdx];
                nextC = c + DIR_X[dirIdx];
            }

            map[r][c] = map[nextR][nextC];
            r = nextR;
            c = nextC;
        }

        map[r][c] = startNum;

        if(rLength / 2 > 1 && cLength / 2 > 1) {
            rotateMap(map, startR + 1, startC + 1, endR - 1, endC - 1);
        }
    }

    static int[][] copyMap(int[][] originMap) {
        int rLength = originMap.length;
        int cLength = originMap[0].length;
        int[][] copiedMap = new int[rLength][cLength];

        for(int r = 1; r < rLength; r++) {
            for(int c = 1; c < cLength; c++) {
                copiedMap[r][c] = originMap[r][c];
            }
        }

        return copiedMap;
    }

    static void minCheck(int[][] map) {
        for(int r = 1; r < map.length; r++) {
            int rSum = 0;
            for(int c = 1; c < map[0].length; c++) {
                rSum += map[r][c];
            }
            if(rSum < min) min = rSum;
        }
    }

    static class RotateRange {
        int startR;
        int startC;
        int endR;
        int endC;

        public RotateRange(int r, int c, int s) {
            startR = r - s;
            startC = c - s;
            endR = r + s;
            endC = c + s;
        }
    }
}
