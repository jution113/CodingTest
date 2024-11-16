import java.io.*;
import java.util.*;

public class Solution {
	static final int N = 4;
	static final int CNT = 7;
	static final int[] DIR_Y = {1, 0, -1, 0};
	static final int[] DIR_X = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			String[][] map =  new String[N][N];
			for(int r = 0; r < N; r++) map[r] = br.readLine().split(" ");
			Set<String> uniqueValue = new HashSet<> ();
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					Queue<TileInfo> queue = new LinkedList<> ();
					queue.offer(new TileInfo(r, c, map[r][c], 0));
					
					while(!queue.isEmpty()) {
						TileInfo tileInfo = queue.poll();
						
						int y = tileInfo.y;
						int x = tileInfo.x;
						String value = tileInfo.value;
						int moveCnt = tileInfo.moveCnt;
						
						if(moveCnt == 6) {
							uniqueValue.add(value);
							continue;
						}
						
						for(int dir = 0; dir < DIR_Y.length; dir++) {
							int nextY = y + DIR_Y[dir];
							int nextX = x + DIR_X[dir];
							if(0 <= nextY && nextY < N && 0 <= nextX && nextX < N) {
								queue.offer(new TileInfo(nextY, nextX, value + map[nextY][nextX], moveCnt + 1));
							}
						}
						
					}
				}
			}
			System.out.println("#" + tc + " " + uniqueValue.size());
		}

	}
	
	static class TileInfo {
		int y;
		int x;
		String value;
		int moveCnt;
		
		public TileInfo(int y, int x, String value, int moveCnt) {
			this.y = y;
			this.x = x;
			this.value = value;
			this.moveCnt = moveCnt;
		}
	}

}
