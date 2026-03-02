import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1];
        int[][] info = new int[N + 1][2];
        
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            info[n] = new int[] {W, V};
        }
        
        for (int n = 1; n <= N; n++) {
            int w = info[n][0];
            int v = info[n][1];
            
            for (int k = 1; k <= K; k++) {
                if (k < w) {
                    dp[n][k] = dp[n - 1][k];
                } else {
                    dp[n][k] = Math.max(dp[n - 1][k], dp[n - 1][k - w] + v);
                }
            }
        }
        
        System.out.println(dp[N][K]);
    }
}