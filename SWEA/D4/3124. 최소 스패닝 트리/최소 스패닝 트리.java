import java.util.*;
import java.io.*;

class Solution {
    // 입출력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    // 트리 관련
    private static int vertexCnt;
    private static int edgeCnt;
    private static PriorityQueue<EdgeInfo> edgeInfos = new PriorityQueue<> ((i, i2) -> {
        return Integer.compare(i.cost, i2.cost);
    });
	private static long minCostSum;
    private static int[] roots;
    
    private static class EdgeInfo {
        int v;
        int v2;
        int cost;
        
        public EdgeInfo(int v, int v2, int cost) {
            this.v = v;
            this.v2 = v2;
            this.cost = cost;
        }
    }
    
	public static void main(String args[]) throws Exception {
        int testCaseCnt = Integer.parseInt(br.readLine());
        
		for(int testCase = 1; testCase <= testCaseCnt; testCase++) {
            init();
            findMinCostSum();
            sb.append("#" + testCase + " " + minCostSum + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        edgeInfos.clear();
        
        st = new StringTokenizer(br.readLine());
        vertexCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());
        
        roots = new int[vertexCnt + 1];
        Arrays.fill(roots, -1);
        minCostSum = 0;
        
        for(int i = 0; i < edgeCnt; i++) {
        	st = new StringTokenizer(br.readLine());
            edgeInfos.offer(new EdgeInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }
    
    private static void findMinCostSum() {
        int connectingEdgeCnt = 0;
        
        while(!edgeInfos.isEmpty() && connectingEdgeCnt < vertexCnt - 1) {
            EdgeInfo edgeInfo = edgeInfos.poll();
            
            int root = findRoot(edgeInfo.v);
            int root2 = findRoot(edgeInfo.v2);
            
            if(root ==  root2)
                continue;
            roots[root] = root2;
            
            minCostSum += edgeInfo.cost;
            connectingEdgeCnt++;
        }
    }
    
    private static int findRoot(int v) {
        if(roots[v] == -1)
            return v;
        roots[v] = findRoot(roots[v]);
        return roots[v];
    }
}