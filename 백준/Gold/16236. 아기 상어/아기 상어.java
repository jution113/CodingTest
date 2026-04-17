import java.io.*;
import java.util.*;

public class Main {
    private static final int DIR_SIZE = 4;
    private static final int[] DIR_Y = {-1, 0, 1, 0};
    private static final int[] DIR_X = {0, 1, 0, -1};
    
    private static int n;
    private static int minMoveSum;
    private static int[][] map;
    
    private static class Shark {
        int[] pos;
        int move;
        int size;
        int eat;
        
        public Shark(int[] pos) {
            this.pos = pos;
            this.move = 0;
            this.size = 2;
            this.eat = 0;
        }
        
        public Shark(int[] pos, int move, int size, int eat) {
            this.pos = pos;
            this.move = move;
            this.size = size;
            this.eat = eat;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        Shark shark = null;
        
        // 맵 초기화
        map = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 9) shark = new Shark(new int[] {y, x});
            }
        }
        
        minMoveSum = 0;
        PriorityQueue<Shark> eatableList = getEatableList(shark);

        while (!eatableList.isEmpty()) {
            map[shark.pos[0]][shark.pos[1]] = 0;
            shark = eatableList.poll();
            shark = moveShark(shark);
            eatableList = getEatableList(shark);
        }
        
        System.out.println(shark.move);
    }
        
    private static PriorityQueue<Shark> getEatableList(Shark start) {
        PriorityQueue<Shark> eatable = new PriorityQueue<> ((a, b) -> {
            if (a.pos[0] == b.pos[0]) {
                return a.pos[1] - b.pos[1];
            }
            return a.pos[0] - b.pos[0];
        });
        
        ArrayDeque<Shark> que = new ArrayDeque<> ();
        que.offer(start);
        
        boolean[][] visit = new boolean[n][n];
        visit[start.pos[0]][start.pos[1]] = true;
        
        int minMove = Integer.MAX_VALUE;
        
        while (!que.isEmpty()) {
            Shark cur = que.poll();
            int y = cur.pos[0];
            int x = cur.pos[1];
            
            for (int d = 0; d < DIR_SIZE; d++) {
                int ny = y + DIR_Y[d];
                int nx = x + DIR_X[d];
                
                // 물리적 조건 검사
                if (ny < 0 || ny == n || nx < 0 || nx == n)
                    continue;
                // 논리적 상태 검사
                if (visit[ny][nx] || map[ny][nx] == 9 || map[ny][nx] > cur.size || cur.move + 1 > minMove)
                    continue;
                
                Shark next = new Shark(new int[] {ny, nx}, cur.move + 1, cur.size, cur.eat);
                
                if (0 < map[ny][nx] && map[ny][nx] < cur.size) {
                    minMove = cur.move + 1;
                    eatable.add(next);
                }
                
                que.offer(next);
                visit[ny][nx] = true;
            }
        }
        
        return eatable;
    }
    
    private static Shark moveShark(Shark shark) {
        int y = shark.pos[0];
        int x = shark.pos[1];
        map[y][x] = 9;
        
        if (shark.size == ++shark.eat) {
            shark.size++;
            shark.eat = 0;
        }
        
        return shark;
    }
}