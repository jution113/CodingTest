import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC  = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
			int[] dp = new int[n];
			int max = 1;
			for(int i = 0; i < n; i++) {
				dp[i] = 1;
				for(int j = 0; j < i; j++) {
					if(arr[i] >= arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				max = Math.max(max, dp[i]);
			}
			System.out.println(String.format("#%d %d", tc, max));
		}
	}
}