import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= TC; tc++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken()); // 재료 수
            int L = Integer.parseInt(st.nextToken()); // 최대 제한 칼로리
            int[] calories = new int[N + 1];
            int[] points = new int[N + 1];
            int[][] dp = new int[N + 1][L + 1];
            
            for(int  n = 1; n <= N; n++) {
                st= new StringTokenizer(br.readLine());
                points[n] = Integer.parseInt(st.nextToken());
                calories[n] = Integer.parseInt(st.nextToken());
            }
            
            for(int n = 1; n <= N; n++) {
                for(int l = 0; l <= L; l++) {
                    if(l < calories[n]) {
                        dp[n][l] = dp[n - 1][l];
                    } else {
                        dp[n][l] = Math.max(dp[n - 1][l], dp[n - 1][l - calories[n]] + points[n]);
                    }
                }
            }
            
            sb.append(String.format("#%d %d\n", tc, dp[N][L]));
        }
        System.out.println(sb.toString());
    }
}