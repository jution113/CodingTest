import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            
            int[][] valArr = new int[2][N + 1];
            for (int r = 0; r < 2; r++) {
                st = new StringTokenizer(br.readLine());
                
                for (int c = 1; c <= N; c++) {
                    valArr[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            
            int[][] dp = new int[2][N + 1];
            dp[0][1] = valArr[0][1];
            dp[1][1] = valArr[1][1];
            
            for (int c = 2; c <= N; c++) {
                dp[0][c] = valArr[0][c] + Math.max(dp[1][c - 1], dp[1][c - 2]);
                dp[1][c] = valArr[1][c] + Math.max(dp[0][c - 1], dp[0][c - 2]);
            }
            
            sb.append(Math.max(dp[0][N], dp[1][N]) + "\n");
        }
        System.out.println(sb.toString());
    }
}