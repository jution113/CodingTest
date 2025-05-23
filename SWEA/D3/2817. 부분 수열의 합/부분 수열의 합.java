import java.io.*;
import java.util.*;

public class Solution {
	static int K;
	static int N;
	static int[] arr;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) comb(0, 0, 0, i);
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int start, int sum, int peekCnt, int maxPeekCnt) {
		if (sum > K) {
			return ;
		}
		if (peekCnt == maxPeekCnt) {
			if (sum == K) cnt++;
			return ;
		}
		
		for (int i = start; i < N; i++) {
			comb(i + 1, sum + arr[i], peekCnt + 1, maxPeekCnt);
		}
	}
}
