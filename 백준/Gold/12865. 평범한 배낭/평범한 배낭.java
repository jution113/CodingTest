import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[N + 1][K + 1];
        int[] weightArr = new int[N + 1];
        int[] valueArr = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weightArr[i] = Integer.parseInt(st.nextToken());
            valueArr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int n = 1; n <= N; n++) {
            for(int w = 0; w <= K; w++) {
                if(w < weightArr[n]) {
                    dp[n][w] = dp[n - 1][w];
                } else {
                    dp[n][w] = Math.max(dp[n - 1][w], dp[n - 1][w - weightArr[n]] + valueArr[n]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}