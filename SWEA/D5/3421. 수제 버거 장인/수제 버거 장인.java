import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n;
    private static int combCnt;
    private static HashMap<Integer, ArrayList<Integer>> bannedSrcCombsBySrc = new HashMap<> ();
    
	public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
		int testCaseLimit = Integer.parseInt(br.readLine());

		for(int t = 1; t <= testCaseLimit; t++) {
            initBannedSrcCombs();
            
            combCnt = 1;
            makeComb(1, new HashSet<> ());
            sb.append("#" + t + " " + combCnt + "\n");
		}
        System.out.print(sb.toString());
	}
    
    private static void initBannedSrcCombs() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        bannedSrcCombsBySrc.clear();
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
            int srcA = Integer.parseInt(st.nextToken());
            int srcB = Integer.parseInt(st.nextToken());
            
            bannedSrcCombsBySrc.put(srcA, bannedSrcCombsBySrc.getOrDefault(srcA, new ArrayList<Integer> ()));
            bannedSrcCombsBySrc.get(srcA).add(srcB);
            bannedSrcCombsBySrc.put(srcB, bannedSrcCombsBySrc.getOrDefault(srcB, new ArrayList<Integer> ()));
            bannedSrcCombsBySrc.get(srcB).add(srcA);
        }        
    }
    
    private static void makeComb(int start, HashSet<Integer> comb) {
        if (start > n) return;
        
        for (int i = start; i <= n; i++) {
            if (!validateComb(i, comb)) continue;
            comb.add(i);
            combCnt++;
            makeComb(i + 1, comb);
            comb.remove(i);
        }
    }
    
    private static boolean validateComb(int src, HashSet<Integer> comb) {
        if (comb.isEmpty() || !bannedSrcCombsBySrc.containsKey(src)) return true;
        for (int bannedSrc : bannedSrcCombsBySrc.get(src)) if (comb.contains(bannedSrc)) return false;
        return true;
    }
}