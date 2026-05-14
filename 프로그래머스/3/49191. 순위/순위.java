import java.util.*;

class Solution {
    private ArrayDeque<int[]> que;
    private ArrayList<GameInfo>[] graph;
    private HashMap<Integer, HashSet<Integer>> map;

    private static class GameInfo {
        int target;
        boolean isWin;
        
        public GameInfo(int target, boolean isWin) {
            this.target = target;
            this.isWin = isWin;
        }
    }
    
    public int solution(int n, int[][] results) {
        que = new ArrayDeque<> ();
        map = new HashMap<> ();
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<> ();
            // [0]: start, [1]: cur, [2]: dir(0: win, 1: lose)
            que.offer(new int[] {i, i, 0});
            que.offer(new int[] {i, i, 1});
            map.put(i, new HashSet<> ());
        }
        
        for (int[] result : results) {
            int a = result[0];
            int b = result[1];
            graph[a].add(new GameInfo(b, true));
            graph[b].add(new GameInfo(a, false));
        }
        
        bfs();

        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (map.get(i).size() == n -1) answer++;
        }
        
        return answer;
    }
    
    private void bfs() {
        while (!que.isEmpty()) {
            int[] node = que.poll();
            int start = node[0];
            int cur = node[1];
            int dir = node[2];
            
            for (GameInfo gameInfo : graph[cur]) {
                if (dir == 0 && gameInfo.isWin && !map.get(start).contains(gameInfo.target)) {
                    que.offer(new int[] {start, gameInfo.target, dir});
                    map.get(start).add(gameInfo.target);
                } else if (dir == 1 && !gameInfo.isWin && !map.get(start).contains(gameInfo.target)) {
                    que.offer(new int[] {start, gameInfo.target, dir});
                    map.get(start).add(gameInfo.target);
                }
            }
        }
    }
}