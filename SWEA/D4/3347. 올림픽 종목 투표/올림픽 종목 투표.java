import java.util.*;
import java.io.*;

class Solution {
    // 입출력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
    
    // 종목 관련
    private static int[] costs;
    private static int[] costLimits;
    private static int maxVotedIdx;
    private static boolean[] voted;
    
	public static void main(String args[]) throws Exception {
       int testCaseCnt = Integer.parseInt(br.readLine());

		for(int testCase = 1; testCase <= testCaseCnt; testCase++) {
            init();
            findMinCostIdx();
            sb.append("#" + testCase + " " + maxVotedIdx + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        costs = new int[Integer.parseInt(st.nextToken())];
        costLimits = new int[Integer.parseInt(st.nextToken())];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < costs.length; i++) costs[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < costLimits.length; i++) costLimits[i] = Integer.parseInt(st.nextToken());
        
        voted = new boolean[costLimits.length];
        maxVotedIdx = 0;
    }
    
    private static void findMinCostIdx() {
        int maxVote = 0;
        
        for (int i = 0; i < costs.length; i++) {
            int vote = 0;
            for (int j = 0; j < costLimits.length; j++) {
                if (voted[j]) continue;
                if (costLimits[j] < costs[i]) continue;
                voted[j] = true;
                vote++;
            }
            if (vote > maxVote) {
                maxVote = vote;
                maxVotedIdx = i + 1;
            }
        }
    }
}