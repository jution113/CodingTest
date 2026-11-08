import java.util.*;
import java.io.*;

class Solution {
    private static final int TOTAL_TEST_CASE = 10;
    private static final int MAX_SIZE = 100;
    
    // 입력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    // 노드 구조 정보
    private static int start;
    private static int n;
    private static boolean[][] adjMatrix;
    
    // 노드 갱신 정보
    private static int maxDepth;
    private static int maxValue;
    private static int maxValueAtMaxDepth;
    
    // 탐색 활용 자료구조
    private static ArrayDeque<int[]> que = new ArrayDeque<> ();
    private static boolean[] visited;
    
	public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        
		for(int testCase = 1; testCase <= TOTAL_TEST_CASE; testCase++) {
            init();
            findMaxValueAtMaxDepth();
            sb.append("#" + testCase + " " + maxValueAtMaxDepth + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());        
        
        adjMatrix = new boolean[MAX_SIZE + 1][MAX_SIZE + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n / 2; i++) {
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = true;
        }
        
        maxDepth = 0;
        maxValueAtMaxDepth = start;
        que.clear();
        visited = new boolean[MAX_SIZE + 1];        
    }
    
    private static void findMaxValueAtMaxDepth() {
        que.offer(new int[] {start, 0});
        visited[start] = true;
        
        while (!que.isEmpty()) {
            int[] info = que.poll();
            int from = info[0];
            int depth = info[1];
            
            if (depth > maxDepth) {
                maxDepth = depth;
                maxValueAtMaxDepth = from;
            } else if (depth == maxDepth) {
                if (from > maxValueAtMaxDepth) maxValueAtMaxDepth = from;
            }
            
            for (int to = 1; to <= MAX_SIZE; to++) {
                if (visited[to]) continue;
                if (!adjMatrix[from][to]) continue;
            	visited[to] = true;
                que.offer(new int[] {to, depth + 1});
            }
        }
    }
}