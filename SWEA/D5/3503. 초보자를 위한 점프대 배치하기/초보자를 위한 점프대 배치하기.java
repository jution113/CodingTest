import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int n;
    private static int[] levels;
    
	public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int totalTestCase = Integer.parseInt(br.readLine());
        
		for(int testCase = 1; testCase <= totalTestCase; testCase++) {
            initLevels();
            sb.append("#" + testCase + " " + findMaxnLevelGap() + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void initLevels() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        levels = new int[n];
        for (int i = 0; i < n; i++)  levels[i] = Integer.parseInt(st.nextToken());
    }
    
    private static int findMaxnLevelGap() {
        Arrays.sort(levels);
        int maxLevelGap = 0;
        
        for (int i = 0; i < n - 2; i++) {
            maxLevelGap = Math.max(maxLevelGap, levels[i + 2] - levels[i]);
        }
        
        return maxLevelGap;
    }
}