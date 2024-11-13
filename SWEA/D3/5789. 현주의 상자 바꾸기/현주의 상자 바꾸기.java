import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int[] boxes = new int[N + 1];
			sb.append(String.format("#%d", tc));
			for(int q = 1; q <= Q; q++) {
				st = new StringTokenizer(br.readLine());
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				for(int i = L; i <= R; i++) boxes[i] = q;
			}
			for(int i = 1; i <= N; i++ ) sb.append(" " + boxes[i]);			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
