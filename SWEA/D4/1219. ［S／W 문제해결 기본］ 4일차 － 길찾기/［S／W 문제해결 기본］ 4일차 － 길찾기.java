import java.util.*;
import java.io.*;

class Solution {
    private static int T = 10;
    
    private static ArrayList<Integer>[] graph;
    
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

		for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            // 그래프 초기화
            graph = new ArrayList[n];
            for (int i = 0; i < n; i++) graph[i] = new ArrayList<> ();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
            
            int answer = dfs(0);
			sb.append("#" + tc + " " + answer + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static int dfs(int start) {
        if (start == 99) return 1;
        
        for (int next : graph[start]) {
            if (dfs(next) == 1) return 1;
        }
        
        return 0;
    }
}