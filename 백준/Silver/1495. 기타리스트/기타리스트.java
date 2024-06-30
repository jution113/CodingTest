import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[n + 1][m + 1];

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());

        if(s - v >= 0) dp[1][s - v] = true;
        if(s + v <= m) dp[1][s + v] = true;

        for(int i = 2; i <= n; i++) {
            v = Integer.parseInt(st.nextToken());

            for(int j = 0; j <= m; j++) {
                if(dp[i - 1][j]) {
                    if(j - v >= 0) dp[i][j - v] = true;
                    if(j + v <= m) dp[i][j + v] = true;
                }
            }
        }

        int max = -1;

        for(int i = m; i >= 0; i--) {
            if(dp[n][i]) {
                max = i;
                break;
            }
        }

        System.out.println(max);
    }
}
