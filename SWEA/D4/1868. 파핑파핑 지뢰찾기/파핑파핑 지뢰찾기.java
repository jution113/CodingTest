import java.util.*;
import java.io.*;

class Solution {
    private static final int DIR = 8;
    private static final int[] DIR_Y = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] DIR_X = {0, 1, 1, 1, 0, -1, -1, -1};
    
    // 입력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 맵 관련
    private static int n;
    private static int[][] map;
    
    // 정답 계산 관련
    private static int clickCnt;
    
	public static void main(String args[]) throws IOException {
        int totalTestCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
		for(int testCase = 1; testCase <= totalTestCase; testCase++) {
            init();
            findMinClickCnt();
            
            sb.append("#" + testCase + " " +  clickCnt + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int y = 0; y < n; y++) {
            String input = br.readLine();
            for (int x = 0; x < n; x++)
                map[y][x] = input.charAt(x) == '.' ? -1 : -2; // 빈칸 -1, 지뢰 -2
        }
        clickCnt = 0;
    }
    
    private static void findMinClickCnt() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (isMine(y, x) || isClicked(y, x)) continue;
                clickCnt++;
                click(y, x);
        		// System.out.println("y, x: " + y + " " + x);
            }
        }
        // System.out.println("----- ----- -----");
    }
    
    private static void click(int y, int x) {
        map[y][x] = getAroundMineCnt(y, x);
        
        for (int dir = 0; dir < DIR; dir++) {
            int nextX = x + DIR_X[dir];
            int nextY = y + DIR_Y[dir];
            
            if (nextX < 0 || nextX == n || nextY < 0 || nextY == n) continue;
            if (isMine(nextY, nextX)) continue;
            if (isClicked(nextY, nextX)) continue;
            
            int aroundMineCnt = getAroundMineCnt(nextY, nextX);
            if (map[y][x] == 0) map[nextY][nextX]  = aroundMineCnt;
            if (aroundMineCnt == 0) click(nextY, nextX);
        }
    }
    
    private static int getAroundMineCnt(int y, int x) {
        int aroundMineCnt = 0;
        
        for (int dir = 0; dir < DIR; dir++) {
            int nextX = x + DIR_X[dir];
            int nextY = y + DIR_Y[dir];
                    
            if (nextX < 0 || nextX == n || nextY < 0 || nextY == n) continue;
            if (isMine(nextY, nextX)) aroundMineCnt++;
        }
        
        return aroundMineCnt;
    } 
    
    private static boolean isMine(int y, int x) {
        return map[y][x] == -2;
    }
    
    private static boolean isClicked(int y, int x) {
        return map[y][x] != -1;
    }
    
    private static void printMap() {
        for (int y = 0; y < n; y++) {
            System.out.println(Arrays.toString(map[y]));
        }
        System.out.println("----- ----- -----");
    }
}