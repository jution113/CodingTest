import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder ();
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			boolean[] check = new boolean[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k < K; k++) {
				int i = Integer.parseInt(st.nextToken());
				check[i] = true;
			}
			sb.append("#" + tc);
			for(int i = 1; i <= N; i++) if(!check[i]) sb.append(" " + i);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
