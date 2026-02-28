import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());        
        int n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            int maxLen = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] >= maxLen) {
                    maxLen = dp[j];
                    dp[i] = maxLen + 1;
                }
            }
        }
        
        int maxLen = dp[0];
        for (int i : dp) {
            maxLen = Math.max(maxLen, i);
        }
        
        System.out.println(maxLen);
    }
}
