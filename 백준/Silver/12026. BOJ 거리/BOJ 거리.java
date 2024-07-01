import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static String input;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = br.readLine();
        dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) continue;
            switch (input.charAt(i)) {
                case 'B':
                    make(i, 'O');
                    break;
                case 'O':
                    make(i, 'J');
                    break;
                default:
                    make(i, 'B');
            }
        }
        
        System.out.println(dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1]);
    }

    static void make(int i, char next) {
        for (int j = i + 1; j < n; j++) {
            if (input.charAt(j) == next) {
                if (dp[j] == -1) {
                    dp[j] = dp[i] + (int) Math.pow(j - i, 2);
                } else {
                    dp[j] = Math.min(dp[j], dp[i] + (int) Math.pow(j - i, 2));
                }
            }
        }
    }
}
