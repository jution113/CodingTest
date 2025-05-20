import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Queue<Obj> q = new LinkedList<> ();
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	static class Obj {
		int num;
		int depth;

		public Obj(int num, int depth) {
			this.num = num;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		q.offer(new Obj(N, 0));
		visited[N] = true;

		while (!q.isEmpty()) {
			Obj obj = q.poll();

			if (obj.num == 1) {
				min = Math.min(min, obj.depth);
				break;
			}
			
			for (int i = 3; i >= 1; i--) {
				int next = 0;
				switch(i) {
					case 1:
						next = obj.num - 1;
						break;
					case 2:
						if (obj.num % 2 != 0) continue;
						next = obj.num / 2;
						break;
					case 3:
						if (obj.num % 3 != 0) continue;
						next = obj.num /3;
						break;
				}
				if (!visited[next]) {
					visited[next] = true;
					q.offer(new Obj(next, obj.depth + 1));
				}
			}
		}

		System.out.println(min);
	}
}
