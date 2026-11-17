import java.util.*;
import java.io.*;

class Solution {
    // 입출력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    // 난이도 관련
    private static int blockCnt;
    private static int[] blocks;
    private static int upLevel;
    private static int downLevel;
    
	public static void main(String args[]) throws IOException {
        int testCaseCnt = Integer.parseInt(br.readLine());

		for(int testCase = 1; testCase <= testCaseCnt; testCase++) {
            init();
            findLevels();
            sb.append("#" + testCase + " " + upLevel + " " + downLevel + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        blockCnt = Integer.parseInt(br.readLine());
        blocks = new int[blockCnt];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < blockCnt; i++) blocks[i] = Integer.parseInt(st.nextToken());
        
        upLevel = 0;
        downLevel = 0;
    }
    
    private static void findLevels() {
        for (int i = 0; i < blockCnt - 1; i++) {
            if (blocks[i] < blocks[i + 1]) {
                upLevel = Math.max(upLevel, blocks[i + 1] - blocks[i]);
            } else {
                downLevel = Math.max(downLevel, blocks[i] - blocks[i + 1]);
            }
        }
    }
}