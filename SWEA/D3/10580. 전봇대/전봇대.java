import java.util.*;
import java.io.*;

class Solution {
    // 입출력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    // 교차선 관련
    private static int lineCnt;
    private static int[][] lines;
    private static int crossCnt;
    private static HashSet<Integer>[] checked;
    
	public static void main(String args[]) throws Exception {
        int caseCaseCnt = Integer.parseInt(br.readLine());

		for(int testCase = 1; testCase <= caseCaseCnt; testCase++) {
            init();
            findCrossCnt();
            sb.append("#" + testCase + " " + crossCnt + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        lineCnt = Integer.parseInt(br.readLine());
        lines = new int[lineCnt][2];
        checked = new HashSet[lineCnt];
        
        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            checked[i] = new HashSet<> ();
        }
        
        Arrays.sort(lines, (int[] line, int[] line2) -> {
            return Integer.compare(line[0], line2[0]);
        });

        crossCnt = 0;
    }
    
    private static void findCrossCnt() {
        for (int i = 0; i < lineCnt; i++) {
            int s = lines[i][0];
            int e = lines[i][1];
            
            for (int j = 0; j < lineCnt; j++) {
                int s2 = lines[j][0];
                int e2 = lines[j][1];
                
                if (((s2 > s && e2 < e) || (s2 < s && e2 > e)) && !checked[j].contains(i)) {
                    checked[i].add(j);
                    crossCnt++;
                }
        	}
        }
    }
}