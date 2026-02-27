import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int searchingStartVertex = Integer.parseInt(st.nextToken());
        
        ArrayList<int[]>[] graph = new ArrayList[vertexCnt + 1];
        for (int i = 1; i <= vertexCnt; i++) {
            graph[i] = new ArrayList<> ();
        }
        
        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int startVertex = Integer.parseInt(st.nextToken());
            int endVertex = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            graph[startVertex].add(new int[] {endVertex, weight});
        }
        
        int[] minWeights = new int[vertexCnt + 1];
        Arrays.fill(minWeights, Integer.MAX_VALUE);
        minWeights[searchingStartVertex] = 0;
        
        bfs(searchingStartVertex, graph, minWeights);
        
        StringBuilder sb = new StringBuilder ();
        for (int i = 1; i <= vertexCnt; i++) {
            String res = minWeights[i] == Integer.MAX_VALUE ? "INF" : String.valueOf(minWeights[i]);
            sb.append(res + "\n");
        }
        System.out.println(sb.toString());
    }
    
    private static void bfs(int searchingStart, ArrayList<int[]>[] graph, int[] minWeights) {
        PriorityQueue<int[]> pq = new PriorityQueue<> ((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {searchingStart, 0});
        
        while (!pq.isEmpty()) {
            int[] startVertex = pq.poll();
            int start = startVertex[0];
            int startWeight = startVertex[1];
            
            for (int[] endVertex : graph[start]) {
                int end = endVertex[0];
                int endWeight = endVertex[1];
                int nextWeight = startWeight + endWeight;
                
                if (nextWeight < minWeights[end]) {
                    minWeights[end] = nextWeight;
                    pq.offer(new int[] {end, nextWeight});
                }
            }
        }
    }
}