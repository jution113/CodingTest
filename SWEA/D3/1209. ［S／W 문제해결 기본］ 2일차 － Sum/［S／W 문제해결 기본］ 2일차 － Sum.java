import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int n = 100;
        
        while(input != null) {
            int tc = Integer.parseInt(input);
            int max = 0;
            int[][] map = new int[n][n];
            
            for(int i = 0; i < n; i++) {
                String[] row = br.readLine().split(" ");
                for(int j = 0; j < n; j++) map[i][j] = Integer.parseInt(row[j]);
            }
            
            for(int i = 0; i < n; i++) {
                int rowSum = 0;
                int colSum = 0;
                for(int j = 0; j < n; j++) {
                    rowSum += map[i][j];
                    colSum += map[j][i];
                }
                max = Math.max(max, rowSum);
                max = Math.max(max, colSum);
            }
            
            int downCrossSum = 0;
            int upCrossSum = 0;
            
            for(int i = 0; i < n; i++) {
                downCrossSum += map[i][i];
                upCrossSum += map[99 - i][i];
            }
            
            max = Math.max(max, downCrossSum);
            max = Math.max(max, upCrossSum);
            
            sb.append("#").append(tc).append(" ").append(max).append("\n");
            input = br.readLine();
        }
        System.out.println(sb.toString());
    }
}