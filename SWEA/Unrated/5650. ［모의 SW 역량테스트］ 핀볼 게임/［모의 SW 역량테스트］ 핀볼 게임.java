import java.util.*;
import java.io.*;

class Solution {
    private static int DIR_LEN = 4;
    private static int[] DIR_Y = {-1, 0, 1, 0};
    private static int[] DIR_X = {0, 1, 0, -1};
    private static int maxScore;
    private static int N;
    private static int[][][] wormholes;
    private static int[][] map;
    private static int sy;
    private static int sx;
    
	public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++) {
            maxScore = 0;
            HashMap<Integer, ArrayList<int[]>> wormholeListByNum = new HashMap<> ();
			N = sc.nextInt();
            wormholes = new int[N][N][2];
            
            // map 초기화
            map = new int[N][N];
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    int num = sc.nextInt();
                    map[y][x] = num;
                    // 웜홀쌍 위치 수집
                    if (num > 5) {
                        if (!wormholeListByNum.containsKey(num)) wormholeListByNum.put(num, new ArrayList<> ());
                        wormholeListByNum.get(num).add(new int[] {y, x});
                    }
                }
            }
            
            // 웜홀 쌍 매핑
            for (Map.Entry<Integer, ArrayList<int[]>> entrySet : wormholeListByNum.entrySet()) {
                int[] wormholePos = entrySet.getValue().get(0);
                int[] wormholePos2 = entrySet.getValue().get(1);
                wormholes[wormholePos[0]][wormholePos[1]] = wormholePos2;
                wormholes[wormholePos2[0]][wormholePos2[1]] = wormholePos;
            }
            
            // dfs 탐색
            for (int y = 0; y < N; y++) {
                sy = y;
                for (int x= 0; x < N; x++) {
                    if (map[y][x] != 0) continue;
                    sx = x;
                    for (int dir = 0; dir < DIR_LEN; dir++) simulate(y + DIR_Y[dir], x +DIR_X[dir], dir);
                }
            }
            
            sb.append("#" + t  + " " + maxScore + "\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static void simulate(int y, int x, int dir) {
        int score = 0;
        
        while (true) {
            if (y < 0 || y == N || x < 0 || x == N) {
                // 벽에 부딪힘 검사
            	dir = (dir + 2) < DIR_LEN ? dir + 2 : (dir + 2) % DIR_LEN;
                y += DIR_Y[dir];
        		x += DIR_X[dir];
            	score++;
                continue;
        	}
            
            // 종료 조건
            if ((y == sy && x == sx) || map[y][x] == -1) break;
            
           if (map[y][x] >= 1 && map[y][x] <= 5) {
        		//  블록에 부딪힘 검사
            	dir = getNextDir(dir, map[y][x]);
            	score++;
        	} else if (map[y][x] > 5) {
            	// 웜홀 검사
               int[] end = wormholes[y][x];
                y = end[0];
                x = end[1];
            }
            y += DIR_Y[dir];
        	x += DIR_X[dir];
        }
        maxScore = Math.max(score, maxScore);
    }
    
    private static int getNextDir(int dir, int block) {
        int nDir = 0;
        
        if (block ==1 && (dir == 2 || dir == 3)) {
            nDir = dir == 2 ? 1 : 0;
        } else if (block == 2 && (dir == 0 || dir == 3)) {
            nDir = dir == 0 ? 1 : 2;
        } else if (block == 3 && (dir == 0 || dir == 1)) {
            nDir = dir == 0 ? 3 : 2;
        } else if (block == 4 && (dir == 1 || dir == 2)) {
            nDir = dir == 1 ? 0 : 3;
        } else {
            nDir = (dir + 2) < DIR_LEN ? dir + 2 : (dir + 2) % DIR_LEN;
        }
        
        return nDir;
    }
}