import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int m;
    private static int mapSize;
    private static int wallSize;
    private static int totalMinTime;
    private static int[][] map;
    private static ArrayList<int[]> virusPosList;
    
    private static final int DIR_SIZE = 4;
    private static final int[] DIR_Y = {-1, 0, 1, 0};
    private static final int[] DIR_X = {0, 1, 0, -1};
    
    private static class Virus {
        int time;
        int[] pos;
        
        public Virus(int time, int[] pos) {
            this.time = time;
            this.pos = pos;
        }
    }
    
    private static void bfs(ArrayList<int[]> peekedPosList, int[][] newMap) {
        int minTime = 0;
        int virusSize = 0;
        ArrayDeque<Virus> que = new ArrayDeque<> ();
        
        // 모든 바이러스 비활성화
        for (int[] pos : virusPosList) {
            newMap[pos[0]][pos[1]] = 3;
        }
        
        for (int[] peekedPos : peekedPosList) {
            que.offer(new Virus(0, Arrays.copyOf(peekedPos, 2)));
            // 선택된 바이러스 활성화
            newMap[peekedPos[0]][peekedPos[1]] = 2;
        }
        
        while (!que.isEmpty()) {
            Virus v = que.poll();
            int y = v.pos[0];
            int x = v.pos[1];
            

            virusSize++;
            
            for (int dir = 0; dir < DIR_SIZE; dir++) {
                int nextY = y + DIR_Y[dir];
                int nextX = x + DIR_X[dir];
                if (nextY < 0 || nextY == n || nextX < 0 || nextX == n) {
                    continue;
                } else if (newMap[nextY][nextX] == 1 || newMap[nextY][nextX] == 2) {
                    continue;
                }
                
                // 이전 최소 탐색 시간을 넘어선, 무의미한 탐색 중단
                // if (v.time + 1 >= totalMinTime) {
                //    return;
                //}
                
                // 비활성화 바이러스를 밟아도 시간은 흐른다. 다만 갱신 시점은 빈 칸을 기준으로 퍼트리는 순간으로 잡아야. 비활성화 바이러스를 밟으며 끝나는 순간과 이미 다 퍼뜨려서 끝난 타이밍을 구분할 수 있다.
                if (newMap[nextY][nextX] == 0) {
                    minTime = Math.max(minTime, v.time + 1);
                }

                newMap[nextY][nextX] = 2;
                que.offer(new Virus(v.time + 1, new int[] {nextY, nextX}));
            }
        }
        
        // 빈 공간 검사
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (newMap[y][x] == 0) return;
            }
        }
        
        totalMinTime = Math.min(totalMinTime, minTime);
    }
    
    private static int[][] mapDeepCopy() {
        int[][] newMap = new int[n][n];
        
        for (int y = 0; y < n; y++) {
            newMap[y] = Arrays.copyOf(map[y], n);
        }
        
        return newMap;
    }
    
    private static void comb(int start, int peekCnt, ArrayList<int[]> peekedPosList) {
        if (peekCnt == m) {
            bfs(peekedPosList, mapDeepCopy());
            return;
        }
        
        for (int i = start; i < virusPosList.size(); i++) {
            peekedPosList.add(virusPosList.get(i));
            comb(i + 1, peekCnt + 1, peekedPosList);
            peekedPosList.remove(peekedPosList.size() - 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        virusPosList = new ArrayList<> ();

        // 맵 초기화
        mapSize = n * n;
        wallSize = 0;
        map = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                
                if (map[y][x] == 2) {
                    virusPosList.add(new int[] {y, x});
                } else if (map[y][x] == 1) {
                    wallSize++;
                }
            }
        }
        
        totalMinTime = Integer.MAX_VALUE;
        
        comb(0, 0, new ArrayList<> ());
        
        if (totalMinTime == Integer.MAX_VALUE) {
            totalMinTime = -1;
        }
        
        System.out.println(totalMinTime);
    }
}