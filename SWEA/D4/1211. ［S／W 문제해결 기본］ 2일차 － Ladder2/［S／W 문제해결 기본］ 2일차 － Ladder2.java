import java.util.*;
import java.io.*;

class Solution {
    private static final int LADDER_LEN = 100;
    
    // 테스트 케이스
    private static int totalTestCase = 10;
    
    // 입력 & 출력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    // 사다리
    private static int[][] ladder;
    private static ArrayList<Integer> startPoints = new ArrayList<> ();
    private static int minDis;
    private static int minDisPath;
    private static int x;
    private static int dis;
    
	public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        
		for(int testCnt = 1; testCnt <= totalTestCase; testCnt++) {
            int testCase = Integer.parseInt(br.readLine());
            init();
            findMinDIsPath();
            sb.append("#" + testCase + " " + minDisPath + "\n");
		}
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        ladder = new int[LADDER_LEN][LADDER_LEN];
        startPoints.clear();
        for (int y = 0; y < LADDER_LEN; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < LADDER_LEN; x++) {
                ladder[y][x] = Integer.parseInt(st.nextToken());
                if (y == 0 && ladder[y][x] == 1) startPoints.add(x);
            }
        }
        minDis = Integer.MAX_VALUE;
        minDisPath = 0;
    }
    
    private static void findMinDIsPath() {
        for (int startPoint : startPoints) {
            x = startPoint;
            findDIs();
            
            if (dis <= minDis){
                minDis = dis;
                minDisPath = startPoint;
            }
        }
    }
    
    private static void findDIs() {
        dis = 0;
        
        for (int y = 0; y < LADDER_LEN; y++) {
	        if (dis > minDis) return;
            if (canMove(y, -1)) {
                move(y, -1);
            } else if (canMove(y, 1)) {
                move(y, 1);
            }
            dis++;
        }
    }
    
    private static boolean canMove(int y, int dir) {
        int nextX = x + dir;
        return (nextX >= 0 && nextX < LADDER_LEN) && ladder[y][nextX] == 1;
    }
    
    private static void move(int y, int dir) {
        while (canMove(y, dir)) {
            x += dir;
            dis++;
        }
    }
}