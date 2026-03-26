import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        // 그래프 초기화
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];
            
            // graph 값: 1(승리), -1(패배), 0(알 수 없음)
            graph[winner][loser] = 1;
            graph[loser][winner] = -1;
        }

        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int winCnt = bfs(i, graph, n, 1);
            int loseCnt = bfs(i, graph, n, -1);
            
            if (winCnt + loseCnt == n - 1)
                answer++;
        }
        
        return answer;
    }
    
    private int bfs(int start, int[][] graph, int n, int gameResult) {
        boolean[] visit = new boolean[n + 1];
        ArrayDeque<Integer> que = new ArrayDeque<> ();
        que.offer(start);
        visit[start] = true;
        
        int cnt = 0;
        
        while (!que.isEmpty()) {
            int cur = que.poll();
            
            for (int next = 1; next <= n; next++) {
                if (visit[next] || graph[cur][next] != gameResult)
                    continue;
                que.offer(next);
                visit[next] = true;
                cnt++;
            }
        }
        
        return cnt;
    }
}