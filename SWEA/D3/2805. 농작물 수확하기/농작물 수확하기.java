import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for(int r = 0; r < N; r++) {
                String[] input = br.readLine().split("");
                for(int c = 0; c < input.length; c++) map[r][c] = Integer.parseInt(input[c]);
            }
            
            int sum = 0;
            int start = N / 2;
            int width = 1;
            
            for(int r = 0; r < N; r++) {                
                for(int c = start; c < start + width; c++) sum += map[r][c];
                if(r < N / 2) {
                    start--;
                    width += 2;
                } else {
                    start++;
                    width -= 2;
                }
            }
            
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}    