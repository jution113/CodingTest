import java.util.*;
import java.io.*;

public class Main {
    static int[] dirY = {1, 0, -1, 0};
    static int[] dirX = {0, 1, 0, -1};
    static int rowLen;
    static int colLen;
    static char[][] map;
    static boolean[][][][] visited;
    
    private static class MoveInfo implements Comparable<MoveInfo> {
        Marble red;
        Marble blue;
        int moveCnt;
        
        public MoveInfo(Marble red, Marble blue, int moveCnt) {
            this.red = red;
            this.blue = blue;
            this.moveCnt = moveCnt;
        }
        
        @Override
        public int compareTo(MoveInfo o) {
            return this.moveCnt - o.moveCnt;
        }
    }
    
    private static class Marble {
        char color;
        int[] pos;
        
        public Marble(char color, int[] pos) {
            this.color = color;
            this.pos = pos;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        rowLen = Integer.parseInt(st.nextToken());
        colLen = Integer.parseInt(st.nextToken());

        
        map = new char[rowLen][colLen];
        Marble red = null;
        Marble blue = null;
        for (int r = 0; r < rowLen; r++) {
            String line = br.readLine();

            for (int c = 0; c < colLen; c++) {
                map[r][c] = line.charAt(c);
                if (map[r][c] == 'R') {
                    red = new Marble('R', new int[] {r, c});
                } else if (map[r][c] == 'B') {
                    blue = new Marble('B', new int[] {r, c});
                }
            }
        }
        
        visited = new boolean[rowLen][colLen][rowLen][colLen];
        visited[red.pos[0]][red.pos[1]][blue.pos[0]][blue.pos[1]] = true;

        System.out.println(bfs(red, blue));
    }
    
    private static int bfs(Marble startRed, Marble startBlue) {
        PriorityQueue<MoveInfo> pq = new PriorityQueue<> ();
        pq.offer(new MoveInfo(startRed, startBlue, 0));
        
        while (!pq.isEmpty()) {
            MoveInfo info = pq.poll();
            Marble red = info.red;
            Marble blue = info.blue;
            
            // 탐색 조건 설정
            if (info.moveCnt == 10) {
                continue;
            }
            
            // 기울이는 방향에 따라 어느 구슬을 먼저 움직일 것인지 설정
            for (int dir = 0; dir < 4; dir++) {
                Marble first = new Marble('R', new int[] {red.pos[0], red.pos[1]});
                Marble second = new Marble('B', new int[] {blue.pos[0], blue.pos[1]});
                
                switch (dir) {
                    case 0: // down
                        if (red.pos[0] < blue.pos[0]) {
                            first = new Marble('B', new int[] {blue.pos[0], blue.pos[1]});
                            second = new Marble('R', new int[] {red.pos[0], red.pos[1]});
                        }
                        break;
                    case 1: // right
                        if (red.pos[1] < blue.pos[1]) {
                            first = new Marble('B', new int[] {blue.pos[0], blue.pos[1]});
                            second = new Marble('R', new int[] {red.pos[0], red.pos[1]});
                        }
                        break;
                    case 2: // up
                        if (red.pos[0] > blue.pos[0]) {
                            first = new Marble('B', new int[] {blue.pos[0], blue.pos[1]});
                            second = new Marble('R', new int[] {red.pos[0], red.pos[1]});
                        }
                        break;
                    case 3: // left
                        if (red.pos[1] > blue.pos[1]) {
                            first = new Marble('B', new int[] {blue.pos[0], blue.pos[1]});
                            second = new Marble('R', new int[] {red.pos[0], red.pos[1]});
                        }
                        break;
                }
                
                boolean isRedInHold = false;
                boolean isBlueInHold = false;
                
                // 첫번째 구슬 굴리기
                while (true) {
                    int firstNextY = first.pos[0] + dirY[dir];
                    int firstNextX = first.pos[1] + dirX[dir];
                    
                    if (firstNextY < 0 || firstNextX < 0 || firstNextY == rowLen || firstNextX == colLen)
                        break;
                    
                    char tile = map[firstNextY][firstNextX];
                    if (tile == '#')
                        break;
                    
                    if (tile == 'O') {
                        if (first.color == 'R') {
                            isRedInHold = true;
                        } else {
                            isBlueInHold = true;
                        }
                        break;
                    }
                    
                    first.pos[0] = firstNextY;
                    first.pos[1] = firstNextX;
                }
                
                boolean isFistInHole = isRedInHold || isBlueInHold;
                
                // 두번째 구슬 굴리기
                while (true) {
                    int secondNextY = second.pos[0] + dirY[dir];
                    int secondNextX = second.pos[1] + dirX[dir];
                    
                    if (secondNextY < 0 || secondNextX < 0 || secondNextY == rowLen || secondNextX == colLen)
                        break;
                    
                    if (!isFistInHole && secondNextY == first.pos[0] && secondNextX == first.pos[1])
                        break;
                    
                    char tile = map[secondNextY][secondNextX];
                    if (tile == '#')
                        break;
                    
                    if (tile == 'O') {
                        if (second.color == 'R') {
                            isRedInHold = true;
                        } else {
                            isBlueInHold = true;;
                        }
                        break;
                    }
                    
                    second.pos[0] = secondNextY;
                    second.pos[1] = secondNextX;
                }
                
                if (isBlueInHold) continue;
                if (isRedInHold) return info.moveCnt + 1;
                
                Marble nextRed = first;
                Marble nextBlue = second;
                
                if (first.color == 'B') {
                    nextRed = second;
                    nextBlue = first;
                }
                
                if (!visited[nextRed.pos[0]][nextRed.pos[1]][nextBlue.pos[0]][nextBlue.pos[1]]) {
                    pq.offer(new MoveInfo(nextRed, nextBlue, info.moveCnt + 1));
                    visited[nextRed.pos[0]][nextRed.pos[1]][nextBlue.pos[0]][nextBlue.pos[1]] = true;
                }
            }
        }
        
        return -1;
    }
}