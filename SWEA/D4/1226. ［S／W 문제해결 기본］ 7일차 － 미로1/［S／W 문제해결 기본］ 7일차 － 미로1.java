import java.util.*;
import java.io.*;

public class Solution {
	static final int N = 16;
	static final int DIR = 4;
	static final int[] DIR_Y = {1, 0, -1, 0};
	static final int[] DIR_X = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			int TC = Integer.parseInt(br.readLine());
			
			// 맵 초기화
			boolean[][] map = new boolean[N][N];
			int startY = 0;
			int startX = 0;
			int endY = 0;
			int endX = 0;
			
			for(int y = 0; y < N; y++) {
				String inputLine = br.readLine();
				for(int x = 0; x < N; x++) {
					switch(inputLine.charAt(x)) {
						case '0':
							map[y][x] = true;
							break;
						case '2':
							map[y][x] = true;
							startY = y;
							startX = x;
							break;
						case '3':
							map[y][x] = true;
							endY = y;
							endX = x;
							break;
						default:
							map[y][x] = false;
					}
				}
			}
			
			int result = dfs(startY, startX, endY, endX, map) ? 1 : 0;
			
			System.out.println("#" + TC + " " + result);
		}
	}
	
	static boolean dfs(int y, int x, int endY, int endX, boolean[][] map) {
		map[y][x] = false;
		if(y == endY && x == endX) return true;
		
		for(int dir = 0; dir < DIR; dir++) {
			int nextY = y + DIR_Y[dir];
			int nextX = x + DIR_X[dir];
			if(0 <= nextY && nextY < N && 0 <= nextX && nextX < N && map[nextY][nextX]) {
				if(dfs(nextY, nextX, endY, endX, map)) return true;
			}
		}
		
		return false;
	}

}
