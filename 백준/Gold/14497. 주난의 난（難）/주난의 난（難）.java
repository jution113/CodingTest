import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static char[][] map;
    static int cnt = 0;
    static boolean isFind;

    static int[] dirY = {1, 0, -1, 0};
    static int[] dirX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        st = new StringTokenizer(br.readLine());
        
        Position player = new Position(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        Position target = new Position(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        for(int i = 0; i < n; i++) {
            String line = br.readLine();

            for(int j = 0; j < m; j++) map[i][j] = line.charAt(j);
        }

        while(!isFind) {
            bfs(player, target);
            cnt++;
        }


        System.out.print(cnt);
    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void bfs(Position start, Position target) {
        Queue<Position> que = new LinkedList<>();
        que.add(start);

        boolean[][] visited = new boolean[n][m];
        visited[start.y][start.x] = true;

        while(!que.isEmpty()) {
            Position pos = que.poll();
            
            for(int i = 0; i < 4; i++) {
                int nextY = pos.y + dirY[i];
                int nextX = pos.x + dirX[i];
                
                if(nextY < 0 || n <= nextY) continue;
                if(nextX < 0 || m <= nextX) continue;
                if(visited[nextY][nextX]) continue;
                
                if(map[nextY][nextX] == '1') {
                    map[nextY][nextX] = '0';
                    visited[nextY][nextX] = true;
                } else if(map[nextY][nextX] == '#') {
                    isFind = true;
                    break;
                } else {
                    visited[nextY][nextX] = true;
                    que.add(new Position(nextY, nextX));
                }
                
            }
        }
    }
}