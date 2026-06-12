import java.util.*;

class Solution {
    private ArrayList<int[]>[] graph;
    private int start;
    private int maxInfection;
    
    public int solution(int n, int infection, int[][] edges, int k) {        
        // 그래프 초기화
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<> ();
        for (int[] edge : edges) {
            graph[edge[0] - 1].add(new int[] {edge[1] - 1, edge[2]});
            graph[edge[1] - 1].add(new int[] {edge[0] - 1, edge[2]});
        }
        
        // 시작 노드 초기화
        start = infection - 1;
        
        // 최대 감염 수 초기화
        maxInfection = 0;
        
        // 파이프 개발 순서 순열 탐색
        makePermutation(0, k, new ArrayList<> ());

        return maxInfection;
    }
    
    private void makePermutation(int depth, int maxDepth, ArrayList<Integer> permutation) {
        if (depth == maxDepth) {
            // 파이프 개방 순서에 맞춰 감염 시물레이션
            bfs(permutation);
            return;
        }
        
        for (int t = 1; t <= 3; t++) {
            permutation.add(t);
            makePermutation(depth + 1, maxDepth, permutation);
            permutation.remove(permutation.size() - 1);
        }
    }
    
    private void bfs(ArrayList<Integer> permutation) {
        ArrayDeque<Integer> que = new ArrayDeque<> ();
        HashSet<Integer> infections = new HashSet<> ();
        infections.add(start);
        
        for (int type : permutation) {
            // 큐 초기화
            for (int infection : infections)
                que.offer(infection);
            
            // 감염 시뮬레이션
            while (!que.isEmpty()) {
                int cur = que.poll();
                
                for (int[] nextInfo : graph[cur]) {
                    int next = nextInfo[0];
                    int nextType = nextInfo[1];
                    
                    // 다음 목적지가 이미 감염되었거나, 파이프 종류가 다르면 이동 불가
                    if (infections.contains(next) || type != nextType)
                        continue;
                    
                    infections.add(next);
                    que.offer(next);
                }
            }
        }
        
        maxInfection = Math.max(maxInfection, infections.size());
    }
}