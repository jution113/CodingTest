import java.io.*;
import java.util.*;

public class Main {
    private static final int[] DIR_Y = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] DIR_X = {0, -1, -1, -1, 0, 1, 1, 1};
    private static final int DIR_SIZE = 8;
    private static final int MAP_SIZE = 4;
    private static final int SHARK_NUM = 17;
    private static int MAX_SUM;
    
    private static class Fish {
        int dir;
        int[] pos;
        
        public Fish(int dir, int[] pos) {
            this.dir = dir;
            this.pos = pos;
        }
    }
    
    // 2차원 배열 깊은 복사
    private static int[][] matrixDeepCopy(int[][] originMap) {
        int[][] newMap = new int[MAP_SIZE][MAP_SIZE];
        
        for (int y = 0; y < MAP_SIZE; y++) {
            newMap[y] = Arrays.copyOf(originMap[y], MAP_SIZE);
        }
        
        return newMap;
    }
    
    // 헤시맵 깊은 복사
    private static HashMap<Integer, Fish> hashMapDeepCopy(HashMap<Integer, Fish> originHashMap) {
        HashMap<Integer, Fish> newHashMap = new HashMap<> ();
        
        for (Map.Entry<Integer, Fish> entrySet : originHashMap.entrySet()) {
            Fish originFish = entrySet.getValue();
            newHashMap.put(entrySet.getKey(), new Fish(originFish.dir, Arrays.copyOf(originFish.pos, 2)));
        }
        
        return newHashMap;
    }
    
    private static void fishMove(int[][] map, HashMap<Integer, Fish> fishByNum) {
        // 물고기 오름차순 이동
        for (int num = 1; num <= 16; num++) {
            if (!fishByNum.containsKey(num))
                continue;
            
            Fish curFish = fishByNum.get(num);
            int y = curFish.pos[0];
            int x = curFish.pos[1];
            
            // 8방향 탐색
            for (int i = 0; i < DIR_SIZE; i++) {
                int dir = (i + curFish.dir) % DIR_SIZE;
                int nextY = y + DIR_Y[dir];
                int nextX = x + DIR_X[dir];
                
                if (nextY < 0 || nextY == MAP_SIZE || nextX < 0 || nextX == MAP_SIZE) {
                    // 맵 경계 이동 검사
                    continue;
                } else if (map[nextY][nextX] == 17) {
                    // 상어 검사
                    continue;
                }
                
                // 위치 이동
                int targetNum = map[nextY][nextX];
                
                if (targetNum != 0) {
                    Fish targetFish = fishByNum.get(targetNum);
                    targetFish.pos[0] = y;
                    targetFish.pos[1] = x;
                }
                
                curFish.pos[0] = nextY;
                curFish.pos[1] = nextX;
                curFish.dir = dir;
                
                map[y][x] = targetNum;
                map[nextY][nextX] = num;
                
               break;
            }
        }
    }
    
    // dfs
    private static void dfs(int[][] map, HashMap<Integer, Fish> fishByNum, int numSum) {
        // 물고기 이동
        fishMove(map, fishByNum);
        
        Fish shark = fishByNum.get(SHARK_NUM);
        int y = shark.pos[0];
        int x = shark.pos[1];
        
        ArrayList<Integer> targetNumList = new ArrayList<> ();
        
        // 상어 이동
        while (true) {
            int nextY = y + DIR_Y[shark.dir];
            int nextX = x + DIR_X[shark.dir];
            
            if (nextY < 0 || nextY == MAP_SIZE || nextX < 0 || nextX == MAP_SIZE) {
                // 맵 경계 이동 검사
                break;
            }
            
            // 상어 동선에 있는 물고기들은 먹을 수 있는 리스트 후보에 추가
            if (map[nextY][nextX] != 0) {
                targetNumList.add(map[nextY][nextX]);
            }
            
            y = nextY;
            x = nextX;
        }
        
        for (int targetNum : targetNumList) {
            int[][] newMap = matrixDeepCopy(map);
            HashMap<Integer, Fish> newFishByNum = hashMapDeepCopy(fishByNum);
            
            Fish targetFish = newFishByNum.get(targetNum);
            newFishByNum.remove(targetNum);
            
            int targetY = targetFish.pos[0];
            int targetX = targetFish.pos[1];
            
            newMap[targetY][targetX] = SHARK_NUM;
            newFishByNum.put(SHARK_NUM, new Fish(targetFish.dir, Arrays.copyOf(targetFish.pos, 2)));
            
            MAX_SUM = Math.max(MAX_SUM, numSum + targetNum);
            
            newMap[shark.pos[0]][shark.pos[1]] = 0;
            
            dfs(newMap, newFishByNum, numSum + targetNum);
        }
    }
    
    public static void main(String[] args) throws IOException {
        int[][] map = new int[MAP_SIZE][MAP_SIZE];
        HashMap<Integer, Fish> fishByNum = new HashMap<> ();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for (int y = 0; y < MAP_SIZE; y++) {
            st = new StringTokenizer(br.readLine());
            
            for (int x = 0; x < MAP_SIZE; x++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                
                map[y][x] = num;
                fishByNum.put(num, new Fish(dir, new int[] {y, x}));
            }
        }
        
        // (0, 0) 자표의 물고기 먹기
        int targetNum = map[0][0];
        Fish targetFish = fishByNum.get(targetNum);
        fishByNum.remove(targetNum);
        
        // 상어 정보 갱신
        map[0][0] = SHARK_NUM;
        fishByNum.put(SHARK_NUM, new Fish(targetFish.dir, Arrays.copyOf(targetFish.pos, 2)));
        MAX_SUM = targetNum;
        
        dfs(map, fishByNum, targetNum);
        
        System.out.println(MAX_SUM);
    }
}