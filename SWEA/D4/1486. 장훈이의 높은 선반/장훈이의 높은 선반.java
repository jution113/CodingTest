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
            findMinGap();
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
    
    private static void findMinGap() {
        for (int i = 1; i <= n; i++) {
            makeHeight(i, new ArrayList<> (), 0, 0);
            if (minGap == 0) break;
        }
    }
    
    private static void makeHeight(int maxPick, ArrayList<Integer> picks, int height, int start) {
        if (height >= targetHeight) {
            minGap = Math.min(minGap, height - targetHeight);
            return;
        }
        if (picks.size() == maxPick) return;
        
        for (int i = start; i < n; i++) {
            picks.add(heights[i]);
            makeHeight(maxPick, picks, height + heights[i], i + 1);
            picks.remove(picks.size() - 1);
        }
    }
}