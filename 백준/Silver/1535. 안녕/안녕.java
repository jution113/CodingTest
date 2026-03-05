import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] lifes = new int[N + 1];
        int[] joys = new int[N + 1];
        for (int n = 1; n <= N; n++) {
            lifes[n] = Integer.parseInt(st1.nextToken());
            joys[n] = Integer.parseInt(st2.nextToken());
        }
        
        int[][] dp = new int[N + 1][100];
        for (int n = 1; n <= N; n++) {
            for (int l = 1; l < 100; l++) {
                if (l < lifes[n]) {
                    dp[n][l] = dp[n - 1][l];
                } else {
                    dp[n][l] = Math.max(dp[n - 1][l], dp[n - 1][l - lifes[n]] + joys[n]);
                }
            }
        }
        
        System.out.println(dp[N][99]);
    }
}