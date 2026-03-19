import java.io.*;
import java.util.*;

public class Main {
    private static int yLen;
    private static int xLen;
    private static int mapSize;
    private static int wallCnt;
    private static int maxSafeAreaCnt;
    private static int[][] map;
    private static ArrayList<int[]> virusStartPosList;

    private static final int DIR_SIZE = 4;
    private static final int[] DIR_Y = {-1, 0, 1, 0};
    private static final int[] DIR_X = {0, 1, 0, -1};
    
    private static int bfs(int[][] newMap) {
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        int virusCnt = 0;
        
        for (int[] virusPos : virusStartPosList) {
            que.offer(virusPos);
        }
        
        while (!que.isEmpty()) {
            int[] virusPos = que.poll();
            int y = virusPos[0];
            int x = virusPos[1];
            virusCnt++;
            
            for (int dir = 0; dir < DIR_SIZE; dir++) {
                int nextY = y + DIR_Y[dir];
                int nextX = x + DIR_X[dir];
                
                // 맵 범위 검사
                if (nextY < 0 || nextY == yLen || nextX < 0 || nextX == xLen) {
                    continue;
                    
                // 벽 검사
                } else if (newMap[nextY][nextX] != 0) {
                    continue;
                }
                
                newMap[nextY][nextX] = 2;
                que.offer(new int[] {nextY, nextX});
            }
        }
        
        return mapSize - (wallCnt + 3 + virusCnt);
    }
    
    private static int[][] matrixDeepCopy(int[][] matrix) {
        int[][] newMatrix = new int[yLen][xLen];
        
        for (int y = 0; y < yLen; y++) {
            newMatrix[y] = Arrays.copyOf(matrix[y], xLen);
        }
        
        return newMatrix;
    }
    
    private static void dfs(int nextY, int nextX, int depth) {
        if (depth == 3) {
            maxSafeAreaCnt = Math.max(maxSafeAreaCnt, bfs(matrixDeepCopy(map)));
            return;
        }
        
        for (int y = nextY; y < yLen; y++) {
            int startX = y == nextY ? nextX : 0;
            for (int x = startX; x < xLen; x++) {
                if (map[y][x] == 0) {
                    map[y][x] = 1;
                    dfs(y, x + 1, depth + 1);
                    map[y][x] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());
        
        map = new int[yLen][xLen];
        mapSize = yLen * xLen;
        virusStartPosList = new ArrayList<> ();
        
        // 맵 초기화
        for (int y = 0; y < yLen; y++) {
            st =  new StringTokenizer(br.readLine());
            
            for (int x = 0; x < xLen; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());

                // 벽 수 카운트
                if (map[y][x] == 1) {
                    wallCnt++;
                    
                // 바이러스 위치 저장
                } else if (map[y][x] == 2) {
                    virusStartPosList.add(new int[] {y, x});
                }
            }
        }
        
        maxSafeAreaCnt = 0;
        dfs(0, 0, 0);
        
        System.out.println(maxSafeAreaCnt);
    }
}