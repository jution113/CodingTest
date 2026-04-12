import java.io.*;
import java.util.*;

public class Main {
    private static final int RGB_SIZE = 3;
    private static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        int[][] rgbVals = new int[n + 1][RGB_SIZE];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int c = 0; c < RGB_SIZE; c++) {
                rgbVals[i][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] rgbValSumsMemo = new int[n + 1][RGB_SIZE];
        for (int i = 1; i <= n; i++) {
            for (int c = 0; c < RGB_SIZE; c++) {
                int val1;
                int val2;
                
                switch (c) {
                    case 0:
                        val1 = rgbValSumsMemo[i - 1][c + 1];
                        val2 = rgbValSumsMemo[i - 1][c + 2];
                        break;
                    case 1:
                        val1 = rgbValSumsMemo[i - 1][c - 1];
                        val2 = rgbValSumsMemo[i - 1][c + 1];
                        break;
                    default:
                        val1 = rgbValSumsMemo[i - 1][c - 2];
                        val2 = rgbValSumsMemo[i - 1][c - 1];
                }
                
                rgbValSumsMemo[i][c] = rgbVals[i][c] + Math.min(val1, val2);
            }
        }
        
        int minVal = Integer.MAX_VALUE;
        for (int c = 0; c < RGB_SIZE; c++) {
            minVal = Math.min(rgbValSumsMemo[n][c], minVal);
        }
        System.out.println(minVal);
    }
}