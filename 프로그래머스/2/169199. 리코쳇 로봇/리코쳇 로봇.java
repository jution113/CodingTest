import java.util.*;

class Solution {
    int[] dirY = {1, 0, -1, 0};
    int[] dirX = {0, 1, 0, -1};
    int[][] map;
    boolean[][] visited;
    
    public int solution(String[] board) {
        int yLen = board.length;
        int xLen = board[0].length();
        map = new int[yLen][xLen];
        visited = new boolean[yLen][xLen];
        Point start = null;
        
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length(); x++) {
                switch(board[y].charAt(x)) {
                    case 'R':
                        map[y][x] = 1;
                        start = new Point(y, x);
                        break;
                    case 'G':
                        map[y][x] = 2;
                        break;
                    case 'D':
                        map[y][x] = 3;
                }
            }
        }
        
        return bfs(start);
    }
    
    private int bfs(Point start) {
        ArrayDeque<Node> que = new ArrayDeque<> ();
        que.offer(new Node(start, 0));
        
        while (!que.isEmpty()) {
            Node node = que.poll();
            int y = node.point.y;
            int x = node.point.x;
            
            for (int dir = 0; dir < 4; dir++) {
                int nextY = y + dirY[dir];
                int nextX = x + dirX[dir];
                
                if (nextY < 0 || nextY >= map.length || nextX < 0 || nextX >= map[0].length) {
                    continue;
                }
                
                if (map[nextY][nextX] == 3) {
                    continue;
                }
                
                Point movedPoint = move(new Point(y, x), dir);
                
                if (visited[movedPoint.y][movedPoint.x]) {
                    continue;
                }
                
                visited[movedPoint.y][movedPoint.x] = true;
                
                if (map[movedPoint.y][movedPoint.x] == 2) {
                    return node.cnt + 1;
                }
                
                que.offer(new Node(movedPoint, node.cnt + 1));
            }
        }
        
        return -1;
    }
    
    private Point move(Point cur, int dir) {
        int y = cur.y;
        int x = cur.x;
        int nextY = y + dirY[dir];
        int nextX = x + dirX[dir];
        
        while ((nextY >= 0 && nextY < map.length) && (nextX >= 0 && nextX < map[0].length) && map[nextY][nextX] != 3) {
            y = nextY;
            x = nextX;
            nextY = y + dirY[dir];
            nextX = x + dirX[dir];
        }
        return new Point(y, x);
    }
    
    private class Point {
        int y;
        int x;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    private class Node {
        Point point;
        int cnt;
        
        public Node(Point point, int cnt) {
            this.point = point;
            this.cnt = cnt;
        }
    }
}