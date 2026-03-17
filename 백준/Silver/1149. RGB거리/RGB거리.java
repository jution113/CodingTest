import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] priceArr = new int[N + 1][3]; 
        
        StringTokenizer st = null;
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                priceArr[n][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[N + 1][3];
        for (int n = 1; n <= N; n++) {
            for (int i = 0; i < 3; i++) {
                int p1;
                int p2;
                
                switch (i) {
                    case 0:
                        p1 = 1;
                        p2 = 2;
                        break;
                    case 1:
                        p1 = 0;
                        p2 = 2;
                        break;
                    default:
                        p1 = 0;
                        p2 = 1;
                }
                
                dp[n][i] = priceArr[n][i] + Math.min(dp[n - 1][p1], dp[n - 1][p2]);
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            res = Math.min(res, dp[N][i]);
        }
        
        System.out.println(res);
    }
}