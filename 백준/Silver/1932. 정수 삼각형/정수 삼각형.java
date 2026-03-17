import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] valArr = new int[N + 1][N + 1];
        for (int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                valArr[n][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], 1000);
        }
        
        for (int n = 1; n <= N; n++) {
            for (int i = 1; i <= n; i++) {
                int v1 = dp[n - 1][i - 1] == 1000 ? 0 : dp[n - 1][i - 1];
                int v2 = dp[n - 1][i] == 1000 ? 0 : dp[n - 1][i];
                dp[n][i] = valArr[n][i] + Math.max(v1, v2);
            }
        }
        
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            res = Math.max(dp[N][i], res);
        }
        System.out.println(res);
    }
}