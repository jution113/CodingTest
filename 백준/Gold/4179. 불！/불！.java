import java.io.*;
import java.util.*;

public class Main {
    static int r;
    static int c;
    static int[][] map;

    static final int DIR_CNT = 4;
    static int[] dirY = {1, 0, -1, 0};
    static int[] dirX = {0, 1, 0, -1};

    static Position player;
    static ArrayList<Position> enemys = new ArrayList<>();

    static boolean isEscape = false;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        // 맵 생성 0(.), 1(#), 2(J), 3(F)
        for(int y = 0; y < r; y++) {
            String inputs = br.readLine();

            for(int x = 0; x < c; x++) {
                char input = inputs.charAt(x);
                int num = 0;

                if(input == '#') {
                    num = 1;
                } else if(input == 'J') {
                    num = 2;
                    player = new Position(2, 0, y, x);
                } else if(input == 'F') {
                    num = 3;
                    enemys.add(new Position(3, 0, y, x));
                }

                map[y][x] = num;
            }
        }

        bfs();

        if(isEscape) {
            System.out.print(result);
        } else {
            System.out.print("IMPOSSIBLE");
        }
    }

    static void bfs() {
        Queue<Position> que = new LinkedList<>();
        for(Position enemy : enemys) que.add(enemy);
        que.add(player);

        boolean[][] visited = new boolean[r][c];
        
        
        while(!que.isEmpty()) {
            Position pos = que.poll();
            visited[pos.y][pos.x] = true;
            
            for(int i = 0; i < DIR_CNT; i++) {
                int nextY = pos.y + dirY[i];
                int nextX = pos.x + dirX[i];

                if(nextY < 0 || r <= nextY || nextX < 0 || c <= nextX) {
                    if(pos.pawn == 2) {
                        result = pos.moveCnt + 1;
                        isEscape = true;
                        que.clear();
                        break;
                    }
                    continue;
                }

                if(visited[nextY][nextX] || map[nextY][nextX] != 0) continue;
                
                if(pos.pawn == 2) {
                    que.add(new Position(pos.pawn, pos.moveCnt + 1, nextY, nextX));
                    map[nextY][nextX] = 2;
                } else {
                    que.add(new Position(pos.pawn, 0, nextY, nextX));
                    map[nextY][nextX] = 3;
                }
            }
        }
    }
    
    static class Position {
        int pawn;
        int moveCnt;
        int y;
        int x;
        
        public Position(int pawn, int moveCnt, int y, int x) {
            this.pawn = pawn;
            this.moveCnt = moveCnt;
            this.y = y;
            this.x = x;
        }
    }
}