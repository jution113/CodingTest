import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] hays;
    private static int haysSum;
    private static int minMoveCnt;
    
	public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
		int totalTestCase = Integer.parseInt(br.readLine());

		for(int testCase = 1; testCase <= totalTestCase; testCase++) {
            init();
            findMinMoveCnt();
            sb.append("#" + testCase + " " + minMoveCnt + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        hays = new int[n];
        haysSum = 0;
        minMoveCnt = 0;
        for (int i = 0; i < n; i++) {
            hays[i] = Integer.parseInt(br.readLine());
            haysSum += hays[i];
        }
    }
    
    private static void findMinMoveCnt() {
        int targetSzie = haysSum / n;
		for (int hay : hays) if (hay > targetSzie) minMoveCnt += hay - targetSzie; 
    }
}