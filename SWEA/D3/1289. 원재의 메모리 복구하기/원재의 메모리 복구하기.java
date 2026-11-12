import java.util.*;
import java.io.*;

class Solution {
    // 입력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    // 메모리
    private static int n;
    private static int[] memory;
    private static int minModifyCnt;
    
    public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
    	int totalTestCase = Integer.parseInt(br.readLine());

		for(int testCase = 1; testCase <= totalTestCase; testCase++) {
            init();
            findMinModifyCnt();
            sb.append("#" + testCase + " " + minModifyCnt + "\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static void init() throws IOException {
        String input = br.readLine();
        n = input.length();
        memory = new int[n];
        for (int i = 0; i < n; i++)
            memory[i] = input.charAt(i) - '0';
        minModifyCnt = 0;
    }
    
    private static void findMinModifyCnt() {
		int bit = 0;
        
        for (int i = 0; i < n; i++) {
            if (memory[i] == bit) continue;
            bit = memory[i];
            minModifyCnt++;
        }
    }
}