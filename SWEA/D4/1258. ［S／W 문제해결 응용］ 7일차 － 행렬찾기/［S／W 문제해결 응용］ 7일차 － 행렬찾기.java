import java.util.*;
import java.io.*;

class Solution {
    // 방향 관련
    private static final int DIR = 4;
    private static final int[] DIR_Y = {-1, 0, 1, 0};
    private static final int[] DIR_X = {0, 1, 0, -1};
    
    // 입출력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    // 맵 관련
    private static int mapLen;
    private static int[][] map;
    private static boolean[][] visited;
    
    // 화물 관련
    private static ArrayList<int[]> subMatrixSizeInfos = new ArrayList<> ();
    
	public static void main(String args[]) throws IOException {
        int testCaseCount = Integer.parseInt(br.readLine());

		for(int testCase = 1; testCase <= testCaseCount; testCase++) {
            init();
            findSubMatrixex();
            subMatrixSizeInfos.sort((info, info2) -> {
                int size = info[0] * info[1];
                int size2 = info2[0] * info2[1];
                
                if (size == size2)
                    return Integer.compare(info[0], info2[0]);
                return Integer.compare(size, size2);
            });
            
            sb.append("#" + testCase + " " + subMatrixSizeInfos.size());
            for (int[] subMatrixSizeInfo : subMatrixSizeInfos)
            	sb.append(" " + subMatrixSizeInfo[0] + " " + subMatrixSizeInfo[1]);
            sb.append("\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        mapLen = Integer.parseInt(br.readLine());
        map = new int[mapLen][mapLen];
        for (int y = 0; y < mapLen; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < mapLen; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        subMatrixSizeInfos.clear();
    }
    
    private static void findSubMatrixex() {
        visited = new boolean[mapLen][mapLen];
        
        for (int y = 0; y < mapLen; y++) {
            for (int x = 0; x < mapLen; x++) {
                if (visited[y][x]) continue;
                if (map[y][x] == 0) continue;
                
                subMatrixSizeInfos.add(getSubMatrixInfo(y, x));
            }
        }
    }
    
    private static int[] getSubMatrixInfo(int y, int x) {
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        que.offer(new int[] {y, x});
        visited[y][x] = true;

        int maxY = y;
        int maxX = x;
        
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            maxY = Math.max(maxY, pos[0]);
            maxX = Math.max(maxX, pos[1]);
            
            for (int i = 0; i < DIR; i++) {
            	int nextY = pos[0] + DIR_Y[i];
            	int nextX = pos[1] + DIR_X[i];
                
                if (nextY < 0 || nextY == mapLen || nextX < 0 || nextX == mapLen) continue;
                if (visited[nextY][nextX]) continue;
                if (map[nextY][nextX] == 0) continue;
                
                visited[nextY][nextX] = true;
                que.offer(new int[] {nextY, nextX});
            }
        }
        
        return new int[] {maxY - y + 1, maxX - x + 1};
    }
}