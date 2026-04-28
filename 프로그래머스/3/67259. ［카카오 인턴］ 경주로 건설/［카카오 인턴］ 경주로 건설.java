import java.util.*;

class Solution {
    private final int DIR_SIZE = 4;
    private final int[] DIR_Y = {-1, 0, 1, 0};
    private final int[] DIR_X = {0, 1, 0, -1};
    
    private int n;
    private int[][] board;
    private int[][][] memo;
    
    private static class Node {
        int[] pos;
        int d;
        int p;
        
        public Node(int[] pos, int d, int p) {
            this.pos = pos;
            this.d = d;
            this.p = p;
        }
    }
    
    public int solution(int[][] board) {
        n = board.length;
        memo = new int[n][n][DIR_SIZE];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                Arrays.fill(memo[y][x], Integer.MAX_VALUE);
            }
        }
        Arrays.fill(memo[0][0], 0);
        this.board = board;
        
        bfs(new int[] {0, 0});
        
        int answer = Integer.MAX_VALUE;
        
        for (int p : memo[n - 1][n - 1]) {
            answer = Math.min(answer, p);
        }
        return answer;
    }
    
    private void bfs(int[] start) {
        PriorityQueue<Node> pq = new PriorityQueue<> ((a, b) -> {
            return Integer.compare(a.p, b.p);
        });
        
        for (int nd = 0; nd < DIR_SIZE; nd++) {
            int ny = start[0] + DIR_Y[nd];
            int nx = start[1] + DIR_X[nd];
            
            if (ny < 0 || ny == n || nx < 0 || nx == n)
                continue;
            if (board[ny][nx] == 1)
                continue;

            memo[ny][nx][nd] = 100;
            pq.offer(new Node(new int[] {ny, nx}, nd, 100));
        }
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int y = cur.pos[0];
            int x = cur.pos[1];
            
            for (int nd = 0; nd < DIR_SIZE; nd++) {
                int ny = y + DIR_Y[nd];
                int nx = x + DIR_X[nd];

                if (ny < 0 || ny == n || nx < 0 || nx == n)
                    continue;
                if (board[ny][nx] == 1)
                    continue;
                int np = cur.p + 100 + ((nd & 1) == (cur.d & 1) ? 0 : 500);
                if (np >= memo[ny][nx][nd])
                    continue;

                memo[ny][nx][nd] = np;
                if (y == n - 1 && x == n - 1)
                    continue;
                pq.offer(new Node(new int[] {ny, nx}, nd, np));
            }
        }
    }
}