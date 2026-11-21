import java.util.*;
import java.io.*;

class Solution {
    private static final int ROOM_CNT = 400;
    
    // 입출력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    // 방 이동 관련
    private static int n;
    private static int[] aisle;
    private static int[][] moveInfos;
    
    private static int minTime;
    
    public static void main(String[] args) throws IOException {
        int testCaseCnt = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
            init();
            findMinTime();
            sb.append("#" + testCase + " " + minTime + "\n");
        }
        
        System.out.print(sb.toString());
    }
    
    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        aisle = new int[(ROOM_CNT / 2)];
        moveInfos = new int[n][2];
        
        for (int i = 0; i < n; i++) {
	        st = new StringTokenizer(br.readLine());
            moveInfos[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        
        minTime = 0;
    }
    
    private static void findMinTime() {
        for (int i = 0; i < n; i++) {
            int[] moveInfo = moveInfos[i];
            int from = (Math.min(moveInfo[0], moveInfo[1]) - 1) / 2;
			int to = (Math.max(moveInfo[0], moveInfo[1]) - 1) / 2 ;
            
            for (int j = from; j <= to;  j++) {
                minTime = Math.max(minTime, ++aisle[j]);
            }
        }
    }
}