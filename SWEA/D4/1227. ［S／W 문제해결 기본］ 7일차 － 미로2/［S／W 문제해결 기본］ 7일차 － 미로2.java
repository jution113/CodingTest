import java.io.*;
import java.util.*;


public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int startY;
    static int startX;
    static int[][] map = new int[100][100];
    static boolean[][] visited;
    static int[] dirY = {-1, 0, 1, 0};
    static int[] dirX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine());
            sb.append("#").append(t).append(" ");
            
            visited = new boolean[100][100];

            for (int y = 0; y < 100; y++) {
                String line = br.readLine();

                for (int x = 0; x < 100; x++) {
                    int n = line.charAt(x) - '0'; 

                    map[y][x] = n;
                    if (n == 2) {
                        startY = y;
                        startX = x;
                    }
                }
            }
            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<> ();
        queue.offer(new Node(startY, startX));
        visited[startY][startX] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int y = node.y;
            int x = node.x;

            for (int i = 0; i < 4; i++) {
                int nextY = y + dirY[i];
                int nextX = x + dirX[i];
                if (nextY < 0 || nextY >= 100 || nextX < 0 || nextX >= 100 || visited[nextY][nextX] || map[nextY][nextX] == 1) continue;
                queue.offer(new Node(nextY, nextX));
                visited[nextY][nextX] = true;
                if (map[nextY][nextX] == 3) return 1;
            }
        }

        return 0;
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}