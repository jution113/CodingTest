import java.util.*;
import java.io.*;

class Solution {
    // 입력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    // 섬 정보
    private static int n;
    private static int[][] islands;
    private static int[] parent;
    
    // 거리 정보
    private static double minCost;
    private static PriorityQueue<DistInfo> minDistInfos = new PriorityQueue<> ((info, info2) -> {
        return Double.compare(info.dist, info2.dist);
    });
    
    private static double e;
    
    private static class DistInfo {
        int from;
        int to;
        double dist;
        
        public DistInfo(int from, int to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
    
	public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
        int totalTestCase = Integer.parseInt(br.readLine());        

        for(int testCase = 1; testCase <= totalTestCase; testCase++) {            
            init();
            findMinDistSum();
            sb.append("#" + testCase + " " + Math.round(minCost) + "\n");
		}
        
       System.out.println(sb.toString());
	}
    
    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        islands = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) islands[i][0] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) islands[i][1] = Integer.parseInt(st.nextToken());
        e = Double.parseDouble(br.readLine());
        
        minDistInfos.clear();
        for (int from = 0; from < n - 1; from++) {
            for (int to = from + 1; to < n; to++) {
                double dist = getDist(islands[from][0], islands[from][1], islands[to][0], islands[to][1]);
                minDistInfos.offer(new DistInfo(from, to, dist));
        		// System.out.println(String.format("%d - > %d = %d", from, to, dist));
            }
        }
        
        minCost = 0;
        parent = new int[n];
    }
    
    private static double getDist(int x, int y, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
    }
    
    private static void findMinDistSum() {
        Arrays.fill(parent, -1);
        int tunnelCnt = 0;
        
        while (!minDistInfos.isEmpty() && tunnelCnt < n - 1) {
			DistInfo info = minDistInfos.poll();
            
            int parentA = findParent(info.from);
            int parentB = findParent(info.to);
            
            if (parentA == parentB) continue;
            
            parent[parentB] = parentA;
            minCost += calculateCost(info.dist);
            tunnelCnt++;
        }
    }
    
    private static int findParent(int island) {
        return parent[island] == -1 ? island : findParent(parent[island]);
    }
    
    private static double calculateCost(double dist) {
        return Math.pow(dist, 2) * e;
    }
}