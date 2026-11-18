import java.util.*;
import java.io.*;

class Solution {
    // 입출력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    // 그래프
    private static int n;
    private static int m;
    private static ArrayList<Integer>[] adjList;
    private static int groupCnt;
    private static boolean[] visited;
    
	public static void main(String args[]) throws IOException {
        int testCaseCnt = Integer.parseInt(br.readLine());
		
        for(int testCase = 1; testCase <= testCaseCnt; testCase++) {
            init();
            findGroupCnt();
            sb.append("#" + testCase + " " + groupCnt + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<> ();
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            
            adjList[from].add(to);
            adjList[to].add(from);
        }
        
        groupCnt = 0;
        visited = new boolean[n];
    }
    
    private static void findGroupCnt() {
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            checkGroup(i);
            groupCnt++;
        }
    }
    
    private static void checkGroup(int from) {
        ArrayDeque<Integer> que = new ArrayDeque<> ();
        
        visited[from] = true;
        que.offer(from);
            
        while (!que.isEmpty()) {
            from = que.poll();
            
            for (int to : adjList[from]) {
                if (visited[to]) continue;
                visited[to] = true;
                que.offer(to);
            }
        }
    }
}