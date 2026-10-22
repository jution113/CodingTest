import java.util.*;
import java.io.*;

class Solution {
    private static final int T = 10;
    private static final int Y_LEN = 100;
    private static final int X_LEN = 100;
    private static final int DIR_LEN = 4;
    private static final int[] DIR_Y = {-1, 0, 1, 0};
    private static final int[] DIR_X = {0, 1, 0, -1};
    
    private static int[][] map;
    private static Node start;

    private static class Node {
        int y;
        int x;
        
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

		for(int t = 1; t <= T; t++) {
            int caseNum = Integer.parseInt(br.readLine());
            int answer = 0;
            map = new int[Y_LEN][X_LEN];
            
            for (int y = 0; y < Y_LEN; y++ ) {
                String input = br.readLine();
                for (int x = 0; x < X_LEN; x++) {
                    map[y][x] = input.charAt(x) - '0';
                    if (map[y][x] == 2) start = new Node(y, x);
                }
            }
            
            answer = bfs();
            
            sb.append("#" + caseNum + " " + answer + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static int bfs() {
        boolean[][] visited = new boolean[Y_LEN][X_LEN];
        visited[start.y][start.x] = true;
        ArrayDeque<Node> que = new ArrayDeque<> ();
        que.offer(start);
        
        while (!que.isEmpty()) {
            Node node = que.poll();
            
            for (int d = 0; d < DIR_LEN; d++) {
                int nextY = node.y + DIR_Y[d];
                int nextX = node.x + DIR_X[d];

                if (visited[nextY][nextX]) continue;
                if (nextY < 0 || nextY >= Y_LEN || nextX < 0 || nextY >= X_LEN) continue;
                if (map[nextY][nextX] == 1) continue;
                if (map[nextY][nextX] == 3) return 1;
                
                visited[nextY][nextX] = true;
                que.offer(new Node(nextY, nextX));
            }
        }
        return 0;
    }
}