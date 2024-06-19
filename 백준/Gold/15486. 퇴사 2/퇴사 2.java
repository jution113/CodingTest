import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            if(i - 1 + T <= N) {
                dp[i - 1 + T] = Math.max(dp[i - 1] + P, dp[i - 1 + T]);
            }

            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        
        Arrays.sort(dp);

        System.out.println(dp[N]);
    }
}