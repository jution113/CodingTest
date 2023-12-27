import java.util.*;
import java.io.*;

public class Main {
    static int target;
    static int minDepth = Integer.MAX_VALUE;
    static int[][] visited = new int[100001][1];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        bfs(start);
        minDepth--;

        sb.append(minDepth).append('\n').append(cnt);

        System.out.print(sb);
    }

    static void bfs(int start) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start, 1));
        visited[start][0] = 1;

        boolean isFind = false;

        while(!que.isEmpty()) {
            Node node = que.poll();
            
            if(node.data == target) {
                if(!isFind) {
                    isFind = true;
                    minDepth = node.depth;
                }

                if(node.depth == minDepth) cnt++;

                continue;
            }
            
            for(int i = 0; i < 3; i++) {
                int nextData = 0;
                int nextDepth = node.depth + 1;

                if(i == 0) nextData = node.data - 1;
                
                if(i == 1) nextData = node.data + 1;
                
                if(i == 2) nextData = node.data * 2;
                
                
                if(0 <= nextData && nextData <= 100000 && (visited[nextData][0] == 0 || nextDepth <= visited[nextData][0])) {
                    visited[nextData][0] = nextDepth;
                    Node nextNode = new Node(nextData, nextDepth);
                    que.add(nextNode);
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