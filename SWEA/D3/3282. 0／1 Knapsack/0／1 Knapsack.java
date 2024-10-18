import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int maxWeight = Integer.parseInt(st.nextToken());
            int[] weightArr = new int[N + 1];
            int[] valueArr = new int[N + 1];
            int[][] dp = new int[N + 1][maxWeight + 1];
            
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                weightArr[i] = Integer.parseInt(st.nextToken());
                valueArr[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i = 1; i <= N; i++) {
                for(int w = 1; w <= maxWeight; w++) {
                    if(w < weightArr[i]) {
                        dp[i][w] = dp[i - 1][w];
                    } else {
                        dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weightArr[i]] + valueArr[i]);
                    }
                }
            }
            
            System.out.println(String.format("#%d %d", tc, dp[N][maxWeight]));
        }
	}
}