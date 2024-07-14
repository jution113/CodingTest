import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String line;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        line = br.readLine();

        dp = new int[n];
        for(int i = 1; i < n; i++) {
            dp[i] = -1;
        }

        for(int i = 0; i < n; i++) {
            if(dp[i] == -1) continue;

            switch(line.charAt(i)) {
                case 'B':
                    solve(i, 'O');
                    break;
                case 'O':
                    solve(i, 'J');
                    break;
                default:
                    solve(i, 'B');
                    break;
            }
        }

        System.out.println(dp[n - 1]);
    }

    static void solve(int i, char next) {
        for(int j = i + 1; j < n; j++) {
            if(line.charAt(j) == next) {
                if(dp[j] == -1) {
                    dp[j] = (j - i) * (j - i) + dp[i];
                } else {
                    dp[j] = Math.min((j - i) * (j - i) + dp[i], dp[j]);
                }
            }
        }
    }
}