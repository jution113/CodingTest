import java.io.*;
import java.util.*;

public class Main {
    private static final int[] DIR_Y = {-1, 0, 1, 0};
    private static final int[] DIR_X = {0, -1, 0, 1};
    private static final int DIR_SIZE = 4;
    
    private static class MoveInfo implements Comparable<MoveInfo> {
        int moveCnt;
        int y;
        int x;
        int size;
        int eatCnt;
        
        public MoveInfo(int moveCnt, int y, int x, int size, int eatCnt) {
            this.moveCnt = moveCnt;
            this.y = y;
            this.x = x;
            this.size = size;
            this.eatCnt = eatCnt;
        }
        
        @Override
        public int compareTo(MoveInfo o) {
            if (this.moveCnt == o.moveCnt) {
                if (this.y == o.y) {
                    return Integer.compare(this.x, o.x);
                } else {
                    return Integer.compare(this.y, o.y);
                }    
            } else {
                return Integer.compare(this.moveCnt, o.moveCnt);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 맵 초기화
        int[][] map = new int[n][n];
        StringTokenizer st = null;
        MoveInfo start = null;
        
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                // 상어 정보 초기화
                if (map[r][c] == 9) {
                    start = new MoveInfo(0, r, c, 2, 0);
                    map[r][c] = 0;
                }
            }
        }
        
        // 탐색
        MoveInfo next = findNext(n, map, start);
        
        while (next != null) {
            start = next;
            next = findNext(n, map, start);
        }
        
        System.out.println(start.moveCnt);
    }
    
    private static MoveInfo findNext(int n, int[][] map, MoveInfo start) {
        boolean[][] visited = new boolean[n][n];
        visited[start.y][start.x] = true;
        
        PriorityQueue<MoveInfo> pq = new PriorityQueue<> ();
        
        ArrayDeque<MoveInfo> que = new ArrayDeque<> ();
        que.offer(start);
        
        while (!que.isEmpty()) {
            
            MoveInfo cur = que.poll();
            int size = cur.size;
            int y = cur.y;
            int x = cur.x;
            
            for (int i = 0; i < DIR_SIZE; i++) {
                int nextY = y + DIR_Y[i];
                int nextX = x + DIR_X[i];
                
                // 이동 검사
                if (nextY < 0 || nextY == n || nextX < 0 || nextX == n) {
                    // 맵 경계 검사
                    continue;
                } else if (visited[nextY][nextX]) {
                    // 중복 방문 여부 검사
                    continue;
                } else if (map[nextY][nextX] > size) {
                    // 물고기 크기를 고려한 방문 가능 여부 검사
                    continue;
                }
                
                visited[nextY][nextX] = true;
                MoveInfo next = new MoveInfo(cur.moveCnt + 1, nextY, nextX, size, cur.eatCnt);

                // 먹을 수 있는 물고기 후보 추가
                if (map[nextY][nextX] > 0 && map[nextY][nextX] < size) {
                    pq.offer(next);
                    continue;
                }

                // 계속 탐색
                que.offer(next);
            }
        }
        
        // 종료 조건 탐색
        if (pq.isEmpty()) {
            // 모든 탐색 완료(방문할 곳 없음)
            return null;
        }
        
        MoveInfo target = pq.poll();
        map[target.y][target.x] = 0;
            
        int eatCnt = target.eatCnt + 1;
        int size = target.size;
            
        if (eatCnt == size) {
            size++;
            eatCnt = 0;
        }
        return new MoveInfo(target.moveCnt, target.y, target.x, size, eatCnt);
    }
}