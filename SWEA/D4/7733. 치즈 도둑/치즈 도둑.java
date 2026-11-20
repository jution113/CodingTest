import java.util.*;
import java.io.*;

class Solution {
    // 이동 관련
    private static final int DIR_CNT = 4;
    private static final int[] DIR_Y = {-1, 0, 1, 0};
    private static final int[] DIR_X = {0, 1, 0, -1};
    
    // 입출력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    private static StringTokenizer st;
    private static StringBuilder sb = new  StringBuilder();
    
    // 치즈 관련
    private static int cheeseLen;
    private static int[][] cheese;
    private static int maxCheeseBlockCnt;
    
    private static int dayLimit;
    private static ArrayDeque<int[]> que = new ArrayDeque<> ();
    private static boolean[][] visited;
    
	public static void main(String args[]) throws Exception {
        int testCaseCnt = Integer.parseInt(br.readLine());

		for(int testCase = 1; testCase <= testCaseCnt; testCase++) {
            init();
            findMaxCheeseBlockCnt();
            sb.append("#" + testCase + " " + maxCheeseBlockCnt + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        cheeseLen = Integer.parseInt(br.readLine());
        cheese = new int[cheeseLen][cheeseLen];
        dayLimit = 1;
        
        for (int y = 0; y < cheeseLen; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < cheeseLen; x++) {
                cheese[y][x] = Integer.parseInt(st.nextToken());
                dayLimit = Math.max(dayLimit, cheese[y][x]);
            }
        }
        
        maxCheeseBlockCnt = 1;
    }
    
    private static void findMaxCheeseBlockCnt() {
        for (int day = 1; day <= dayLimit; day++) {
            eatCheese(day);
            maxCheeseBlockCnt = Math.max(maxCheeseBlockCnt, getkCheeseBlockCnt());
        }
    }
    
    private static void eatCheese(int day) {
        que.clear();
        
        for (int y = 0; y < cheeseLen; y++) {
            for (int x = 0; x < cheeseLen; x++) {
                if (cheese[y][x] != day) continue;
                cheese[y][x] = -1;
                que.offer(new int[] {y, x});
                
                while (!que.isEmpty()) {
                    int[] pos = que.poll();
                    
                    for (int d = 0; d < DIR_CNT; d++) {
                        int nextY = pos[0] + DIR_Y[d];
                        int nextX = pos[1] + DIR_X[d];
                        
                        if (nextY < 0 || nextY >= cheeseLen || nextX < 0 || nextX >= cheeseLen) continue;
                        if (cheese[nextY][nextX] != day) continue;
                        cheese[nextY][nextX] = -1;
                        que.offer(new int[] {nextY, nextX});
                    }
                }
            }
        }
    }
    
    private static int getkCheeseBlockCnt() {
        visited = new boolean[cheeseLen][cheeseLen];
        que.clear();
        int cheeseBlockCnt = 0;
        
        for (int y = 0; y < cheeseLen; y++) {
            for (int x = 0; x < cheeseLen; x++) {
                if (cheese[y][x] == -1 || visited[y][x]) continue;
            	visited[y][x] = true;
                que.offer(new int[] {y, x});
	            cheeseBlockCnt++;
                
                while (!que.isEmpty()) {
                    int[] pos = que.poll();
                    
                    for (int d = 0; d < DIR_CNT; d++) {
                        int nextY = pos[0] + DIR_Y[d];
                        int nextX = pos[1] + DIR_X[d];
                        
                        if (nextY < 0 || nextY >= cheeseLen || nextX < 0 || nextX >= cheeseLen) continue;
                        if (cheese[nextY][nextX] == -1 || visited[nextY][nextX]) continue;
                        visited[nextY][nextX] = true;
                        que.offer(new int[] {nextY, nextX});
                    }
                }
            }
        }
        
        return cheeseBlockCnt;
    }
}