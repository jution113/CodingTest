import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
            if (i == 1) {
                dp[i] = num;
            } else if (i == 2) {
                dp[i] = dp[i - 1] + num;
            } else {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + nums[i - 1]) + num;
            }
        }
        System.out.println(dp[n]);
    }
}