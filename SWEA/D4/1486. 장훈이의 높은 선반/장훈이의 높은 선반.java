import java.util.*;
import java.io.*;

class Solution {
    // 입력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st; 
    
    // 키 정보
    private static int n;
    private static int targetHeight;
    private static int[] heights;
    private static int minGap;
    
	public static void main(String args[]) throws IOException {
        int totalTest = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
		for(int testCase = 1; testCase <= totalTest; testCase++) {
            init();
            findMinGap(new ArrayList<> (), 0, 0);
            sb.append("#" + testCase + " " + minGap + "\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        targetHeight = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        heights = new int[n];
        for (int i = 0; i < n; i++) heights[i] = Integer.parseInt(st.nextToken());
        
        minGap = Integer.MAX_VALUE;
    }
    
    private static void findMinGap(ArrayList<Integer> picks, int height, int start) {
        int gap =  height - targetHeight;
        
        if (gap > minGap) return;
        if (height >= targetHeight) {
            minGap = Math.min(minGap, gap);
            return;
        }
        if (picks.size() == n) return;
        
        for (int i = start; i < n; i++) {
            picks.add(heights[i]);
            findMinGap(picks, height + heights[i], i + 1);
            picks.remove(picks.size() - 1);
        }
    }
}