import java.io.*;
import java.util.*;

public class Main {
    static int[][] moveCases = {
        {9, 3, 1},
        {9, 1, 3},
        {3, 9, 1},
        {3, 1, 9},
        {1, 9, 3},
        {1, 3, 9},
    };
    static final int DIMENSION = 3;
    static final int MAX_POINT = 61;
    static boolean[][][] visited = new boolean[MAX_POINT][MAX_POINT][MAX_POINT];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] startPoint = new int[DIMENSION];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) startPoint[i] = Integer.parseInt(st.nextToken());

        bfs(new PointData(startPoint[0], startPoint[1], startPoint[2], 0));
    }

    static void bfs(PointData startPointData) {
        Queue<PointData> que = new ArrayDeque<>();
        que.add(startPointData);
        
        while(!que.isEmpty()) {
            PointData pointData = que.poll();
            int x = pointData.x;
            int y = pointData.y;
            int z = pointData.z;
            int moveCnt = pointData.moveCnt;
            
            if(!visited[x][y][z]) {
                visited[x][y][z] = true;
                for(int[] moveCase : moveCases) {
                   int nextX = x - moveCase[0] < 0 ? 0 : x - moveCase[0];
                   int nextY = y - moveCase[1] < 0 ? 0 : y - moveCase[1];
                   int nextZ = z - moveCase[2] < 0 ? 0 : z - moveCase[2];
                   if(nextX == 0 && nextY == 0 && nextZ == 0) {
                    System.out.print(moveCnt + 1);
                    System.exit(0);
                   }
                   que.add(new PointData(nextX, nextY, nextZ, moveCnt + 1));
                }
            }
        }
    }

    static class PointData {
        int x;
        int y;
        int z;
        int moveCnt;

        public PointData(int x, int y, int z, int moveCnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.moveCnt = moveCnt;
        }
    }
}