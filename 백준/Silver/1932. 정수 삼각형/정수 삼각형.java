import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        // 초기화
        int[][] vals = new int[n + 1][n + 1];
        for (int h = 1; h <= n; h++) {
            st = new StringTokenizer(br.readLine());
            
            for (int w = 1; w <= h; w++) {
                vals[h][w] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 메모이제이션을 통한 최대값 갱신
        int[][] maxValsMemo = new int[n + 1][n + 1];
        for (int h = 1; h <= n; h++) {
            for (int w = 1; w <= n; w++) {
                maxValsMemo[h][w] = vals[h][w] + Math.max(maxValsMemo[h - 1][w - 1], maxValsMemo[h - 1][w]);
            }
        }
        
        int maxVal = 0;
        for (int val : maxValsMemo[n]) {
            maxVal = Math.max(maxVal, val);
        }
        
        System.out.println(maxVal);
    }
}