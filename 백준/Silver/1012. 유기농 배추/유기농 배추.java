import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] dirY = {-1, 0, 1, 0};
	static int[] dirX = {0, 1, 0, -1};
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			Queue<Point> points = new LinkedList<> ();
			int cnt = 0;

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
				points.offer(new Point(y, x));
			}

			while (!points.isEmpty()) {
				Point point = points.poll();
				int y = point.y;
				int x = point.x;
				if (map[y][x] == 1) {
					cnt++;
					dfs(y, x);
				}
			}
			sb.append(cnt).append("\n");

		}
		System.out.print(sb);
	}

	static void dfs(int y, int x) {
		map[y][x] = 0;
		
		for (int i = 0; i < 4; i++) {
			int nextY = y + dirY[i];
			int nextX = x + dirX[i];

			if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && map[nextY][nextX] == 1)
				dfs(nextY, nextX);
		}
	}

	static class Point {
		int y;
		int x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
