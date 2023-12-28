import java.io.*;
import java.util.*;

public class Main {
    static int start;
    static int target;
    static int minDepth = Integer.MAX_VALUE;
    static int[][] visited = new int[100001][2]; // 0: depth, 1: parent
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        bfs(start);

        System.out.print(sb);
    }
    
    static void bfs(int startData) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startData, 0));
        
        while(!que.isEmpty()) {
            Node node = que.poll();
            visited[startData][0] = node.depth;
            visited[startData][1] = -1;
            
            if(node.data == target) {
                minDepth = node.depth;
                sb.append(minDepth).append('\n');

                int[] result = new int[node.depth + 1];
                int idx = result.length - 1;
                result[idx] = node.data;
                idx--;
                int parent = visited[node.data][1];

                while(parent != -1) {
                    result[idx] = parent;
                    idx--;
                    parent = visited[parent][1];
                }

                for(int i : result) sb.append(i).append(' ');

                break;
            }
            
            for(int i = 0; i < 3; i++) {
                int nextData = 0;

                if(i == 0) nextData = node.data + 1;
                
                if(i == 1) nextData = node.data - 1;
                
                if(i == 2) nextData = node.data * 2;

                if(0 <= nextData && nextData <= 100000) {
                    if((visited[nextData][0] == 0 && nextData != startData) || node.depth + 1 <= visited[nextData][0]) {
                        que.add(new Node(nextData, node.depth + 1));
                        visited[nextData][0] = node.depth + 1;
                        visited[nextData][1] = node.data;
                    }
                }
            }
        }
    }

    static class Node {
        int data;
        int depth;

        public Node(int data, int depth) {
            this.data = data;
            this.depth = depth;
        }
    }
}