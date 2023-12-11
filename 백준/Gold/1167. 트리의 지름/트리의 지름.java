import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Node>[] adjList;
    static boolean[] visited;
    static int maxDiameter = 0;
    static int furthestV = 1;

    static class Node {
        int data;
        int weight;

        public Node(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        // 인접리스트 초기화
        adjList = new ArrayList[V + 1];
        for(int i = 0; i < adjList.length; i++ ) {
            adjList[i] = new ArrayList<>();
        }

        // 인접리스트 생성
        for(int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startV = Integer.parseInt(st.nextToken());

            while(true) {
                int targetV = Integer.parseInt(st.nextToken());
                if(targetV == -1) break;

                int weight = Integer.parseInt(st.nextToken());

                adjList[startV].add(new Node(targetV, weight));
                adjList[targetV].add(new Node(startV, weight));
            }
        }
        
        visited = new boolean[V + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[V + 1];
        visited[furthestV] = true;
        dfs(furthestV, 0);

        System.out.println(maxDiameter);
    }

    static void dfs(int startNodeData, int startDiaMeter) {
        for(Node adjNode : adjList[startNodeData]) {
            if(visited[adjNode.data]) continue;
            visited[adjNode.data] = true;
            dfs(adjNode.data, startDiaMeter + adjNode.weight);
        }

        if(maxDiameter < startDiaMeter) 
        {
            maxDiameter = startDiaMeter;
            furthestV = startNodeData;
        }
    }
}