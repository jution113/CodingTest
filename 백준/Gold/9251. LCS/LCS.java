import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr1 = br.readLine().toCharArray();
        char[] charArr2 = br.readLine().toCharArray();
        int[][] dp = new int[charArr1.length + 1][charArr2.length + 1];
        
        for (int i = 1; i <= charArr1.length; i++) {
            for (int j = 1; j <= charArr2.length; j++) {
                if (charArr1[i - 1] == charArr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        System.out.println(dp[charArr1.length][charArr2.length]);
    }
}