import java.io.*;
import java.util.*;

public class Main {
	static int w;
	static int h;
	static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int cnt = 0;

			if (w == 0 && h == 0) break ;
			if (w == 0 || h == 0) {
				sb.append("0").append("\n");
				continue ;
			}

			map = new int[h][w];
			visited = new boolean[h][w];
			for (int y = 0; y < h; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < w; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
					visited[y][x] = map[y][x] == 0;
				}
			}

			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					if (!visited[y][x]) {
						dfs(y, x);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}

	static void dfs(int y, int x) {
		visited[y][x] = true;

		for (int i = 0; i < 8; i++) {
			int nextY = y + dirY[i];
			int nextX = x + dirX[i];
			if (nextY >= 0 && nextY < h && nextX >= 0 && nextX < w && !visited[nextY][nextX]) dfs(nextY, nextX);
		}
	}

}
