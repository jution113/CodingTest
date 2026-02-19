import java.util.*;

class Solution {
    static class Node {
        int num;
        int time;
        
        public Node (int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        // 그래프 초기화
        ArrayList<Node>[] graph = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<> ();
        }
        
        for (int[] node : road) {
            graph[node[0]].add(new Node(node[1], node[2]));
            graph[node[1]].add(new Node(node[0], node[2]));
        }
        
        // 최소 방문 횟수 저장 배열 초기화
        int[] minTimeByNode = new int[N + 1];
        Arrays.fill(minTimeByNode, Integer.MAX_VALUE);
        
        bfs(graph, minTimeByNode, K);
        
        int answer = 0;
        for (int minTime : minTimeByNode) {
            if (minTime != Integer.MAX_VALUE) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void bfs(ArrayList<Node>[] graph, int[] minTimeByNode, int K) {
        ArrayDeque<Node> que = new ArrayDeque<> ();
        que.offer(new Node(1, 0));
        minTimeByNode[1] = 0; 
        
        while (!que.isEmpty()) {
            Node node = que.poll();
            
            for (Node nextNode : graph[node.num]) {
                int nextTime = node.time + nextNode.time;
                
                if (nextTime <= K && nextTime < minTimeByNode[nextNode.num]) {
                    que.offer(new Node(nextNode.num, nextTime));
                    minTimeByNode[nextNode.num] = nextTime;
                }
            }
        }
        
    }
}