import java.util.*;

class Solution {
    static final int DIR_LEN = 4; 
    static final int[] DIR_Y = {1, 0, -1, 0};
    static final int[] DIR_X = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        int yLen = maps.length;
        int xLen = maps[0].length();
        Node start = null;
        Node lever = null;
        Node end = null;
        
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                switch(maps[y].charAt(x)) {
                    case 'S':
                        start = new Node(y, x, 0);
                        break;
                    case 'L':
                        lever = new Node(y, x, 0);
                        break;
                    case 'E':
                        end = new Node(y, x, 0);
                        break;
                }
            }
            if (start != null && lever != null && end != null)
                break;
        }
        
        int depth = bfs(start, lever, maps, yLen, xLen);
        if (depth == -1)
            return -1;
        int depth2 = bfs(lever, end, maps, yLen, xLen);
        if (depth2 == -1)
            return -1;
        
        return depth + depth2;
    }
    
    int bfs(Node start, Node end, String[] maps, int yLen, int xLen) {
        boolean[][] visited = new boolean[yLen][xLen];
        ArrayDeque<Node> que = new ArrayDeque<> ();
        que.offer(start);
        visited[start.y][start.x] = true;
        
        while (!que.isEmpty()) {
            Node n = que.poll();
            if (n.y == end.y && n.x == end.x) {
                return n.depth;
            }
            
            for (int i = 0; i < DIR_LEN; i++) {
                int nextY = n.y + DIR_Y[i];
                int nextX = n.x + DIR_X[i];
                
                if (nextY >= yLen || nextY < 0 || nextX >= xLen || nextX < 0 || visited[nextY][nextX] || maps[nextY].charAt(nextX) == 'X') {
                    continue;
                }
                
                que.offer(new Node(nextY, nextX, n.depth + 1));
                visited[nextY][nextX] = true;
            }
        }
        
        return -1;
    }
    
    static class Node {
        int y;
        int x;
        int depth;
        
        public Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}