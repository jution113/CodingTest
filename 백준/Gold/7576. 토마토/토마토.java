import java.io.*;
import java.util.*;

public class Main {
    private static final int DIR_SIZE = 4;
    private static final int[] DIR_Y = {-1, 0, 1, 0};
    private static final int[] DIR_X = {0, 1, 0, -1};
    
    private static class Tomato {
        int day;
        int[] pos;
        
        public Tomato(int day, int[] pos) {
            this.day = day;
            this.pos = pos;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xLen = Integer.parseInt(st.nextToken());
        int yLen = Integer.parseInt(st.nextToken());
        int[][] map = new int[yLen][xLen];
        boolean[][] visit = new boolean[yLen][xLen];
        
        ArrayDeque<Tomato> que = new ArrayDeque<> ();
        
        for (int y = 0; y < yLen; y++) {
            st = new StringTokenizer(br.readLine());
            
            for (int x = 0; x < xLen; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                
                if (map[y][x] == 1) {
                    que.offer(new Tomato(0, new int[] {y, x}));
                    visit[y][x] = true;
                }
            }
        }
        
        int totalDay = 0;
        
        while (!que.isEmpty()) {
            Tomato tomato = que.poll();
            int y = tomato.pos[0];
            int x = tomato.pos[1];
            
            for (int d = 0; d < DIR_SIZE; d++) {
                int ny = y + DIR_Y[d];
                int nx = x + DIR_X[d];
                
                if (ny < 0 || ny == yLen || nx < 0 || nx == xLen)
                    continue;
                if (map[ny][nx] != 0 || visit[ny][nx])
                    continue;
                
                visit[ny][nx] = true;
                map[ny][nx] = 1;
                
                que.offer(new Tomato(tomato.day + 1, new int[] {ny, nx}));
                totalDay = Math.max(totalDay, tomato.day + 1);
            }
        }
        
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (map[y][x] == 0) {
                    totalDay = -1;
                    break;
                }
            }
        }
        
        System.out.println(totalDay);
    }
}