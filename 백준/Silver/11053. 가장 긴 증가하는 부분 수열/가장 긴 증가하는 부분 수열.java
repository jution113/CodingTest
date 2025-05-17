import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] src;
    static int[] dp;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        src = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (src[i] > src[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
