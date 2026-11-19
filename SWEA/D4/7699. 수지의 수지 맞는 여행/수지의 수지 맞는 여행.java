import java.util.*;
import java.io.*;

class Solution {
    // 섬 인덱스 관련
    private static final int ISLAND_IDX_BASE = 64;
    
    // 이동 관련
    private static int DIR_CNT = 4;
    private static int[] DIR_Y = {-1, 0, 1, 0};
    private static int[] DIR_X = {0, 1, 0, -1};
    
	// 입출력 관련    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    // 맵 관련
    private static int yLen;
    private static int xLen;
    private static int[][] map;
    private static int totalIslandCnt; 
    
    // 탐색 관련
    private static int maxVisitedCnt;
    
	public static void main(String args[]) throws Exception {
        int testCaseCnt = Integer.parseInt(br.readLine());

		for(int testCase = 1; testCase <= testCaseCnt; testCase++) {
            init();
            findMaxVisitedCnt(0, 0, 1 << map[0][0], 1);
            sb.append("#" + testCase + " " + maxVisitedCnt + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());
        map = new int[yLen][xLen];
        totalIslandCnt = 0;
        
        int visited = 0;
        
        for (int y = 0; y < yLen; y++) {
            String rowInfoLine = br.readLine();

            for (int x = 0; x < xLen; x++) {
            	map[y][x] = rowInfoLine.charAt(x) - ISLAND_IDX_BASE;
                
                if ((visited & (1 << map[y][x])) == 0) {
                    visited |= (1 << map[y][x]);
                    totalIslandCnt++;
                }
            }
        }
        
		maxVisitedCnt = 1;
    }
    
    private static void findMaxVisitedCnt(int y, int x, int visitedMask, int visitedCnt) {
        for (int i = 0; i < DIR_CNT; i++) {
            int nextY = y + DIR_Y[i];
            int nextX = x + DIR_X[i];
            
            if (nextY < 0 || nextY >= yLen || nextX < 0 || nextX >= xLen) continue;
	        if ((visitedMask & (1 << map[nextY][nextX])) > 0) continue;
            
            maxVisitedCnt = Math.max(visitedCnt + 1, maxVisitedCnt);
            
            if (maxVisitedCnt == totalIslandCnt)
                return;
            
            findMaxVisitedCnt(nextY, nextX, visitedMask | (1 << map[nextY][nextX]), visitedCnt + 1);
        }
    }
}