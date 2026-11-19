import java.util.*;
import java.io.*;

class Solution {
    // 입출력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    // 문자열 관련
    private static int n;
    private static int m;
    private static HashMap<String, Integer> cntByStr = new HashMap<> ();
    
	public static void main(String args[]) throws IOException {
		int testCaseCnt = Integer.parseInt(br.readLine());
        
		for(int testCase = 1; testCase <= testCaseCnt; testCase++) {
            init();
            int dupStrCnt = 0;
            
            for (Map.Entry<String, Integer> entry : cntByStr.entrySet()) {
                //System.out.println(entry.getKey() + " : " + entry.getValue());
                if (entry.getValue() > 1) dupStrCnt++;
            }
            
            sb.append("#" + testCase + " " + dupStrCnt + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        cntByStr.clear();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = st.nextToken();
	        cntByStr.put(str, cntByStr.getOrDefault(str, 0) + 1);
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            String str = st.nextToken();
	        cntByStr.put(str, cntByStr.getOrDefault(str, 0) + 1);
        }
    }
}