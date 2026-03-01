import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][N + 1];
        
        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            
            for (int x = 1; x <= N; x++) {
                int num = Integer.parseInt(st.nextToken());
                
                dp[y][x] = num + dp[y - 1][x] + dp[y][x - 1] - dp[y - 1][x - 1];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            
            int res = dp[y2][x2] - (dp[y2][x1 - 1] + dp[y1 - 1][x2] - dp[y1 - 1][x1 - 1]);
            sb.append(res + "\n");
        }
        System.out.println(sb.toString());
    }
}