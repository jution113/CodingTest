import java.util.*;
import java.io.*;

// n(1 <= n <= 10000)
// root = 1

public class Main {
    static ArrayList<Node>[] adjList;
    static boolean[] visited;
    static int maxDiameter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCnt = Integer.parseInt(br.readLine());

        // 입력이 1일 경우 0 반환
        if(nodeCnt == 1) {
            System.out.println(0);
            return;
        }

        // 인접 리스트 생성
        adjList = new ArrayList[10001];

        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 노드에 대한 정보 입력 받아 트리 생성
        for(int i = 0; i < nodeCnt - 1; i++) {
            // 노드에 대한 정보 분석
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parentData = Integer.parseInt(st.nextToken());
            int data = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 연관관계 설정
            adjList[parentData].add(new Node(data, weight));
            adjList[data].add(new Node(parentData, weight));
        }

        for(int i = 0; i <= nodeCnt; i++) {
            visited = new boolean[10001];
            visited[i] = true;
            
            findTreeDiameter(i, 0);
        }

        System.out.println(maxDiameter);

    }
    
    // 노드 클래스
    static class Node {
        int data;
        int weight;

        public Node(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }

    static void findTreeDiameter(int startNodeData, int diameter) {
        for(Node node : adjList[startNodeData]) {
            if(!visited[node.data]) {
                visited[node.data] = true;
                findTreeDiameter(node.data, diameter + node.weight);
            }
        }

        maxDiameter = maxDiameter > diameter ? maxDiameter : diameter;
        
    }
}