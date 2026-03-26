import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n];
        int answer = 0;
        
        for (int start = 0; start < n; start++) {
            if (!visit[start]) {
                bfs(start, computers, visit, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void bfs(int init, int[][] computers, boolean[] visit, int n) {
        ArrayDeque<Integer> que = new ArrayDeque<> ();
        que.offer(init);
        
        while (!que.isEmpty()) {
            int start = que.poll();
            visit[start] = true;
            
            for (int end = 0; end < n; end++) {
                if (!visit[end] && computers[start][end] == 1)
                    que.offer(end);
            }
        }
    }
}