import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static long[][] memo;
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        memo = new long[n + 1][n + 1];
        
        for (int y = 1; y <= n; y++) {
            st = new StringTokenizer(br.readLine());
            
            for (int x = 1; x <= n; x++) {
                long num = Long.parseLong(st.nextToken());
                memo[y][x] = memo[y][x - 1] + memo[y - 1][x] - memo[y - 1][x - 1] + num;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            
            long res = memo[y2][x2] - (memo[y2][x - 1] + memo[y - 1][x2] - memo[y - 1][x - 1]);
            sb.append(res + "\n");
        }
        
        System.out.println(sb.toString());
    }
}