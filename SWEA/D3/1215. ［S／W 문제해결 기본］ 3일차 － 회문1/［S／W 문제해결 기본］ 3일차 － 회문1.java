import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = 10;
        StringBuilder sb = new StringBuilder();
        
        for(int tc = 1; tc <= TC; tc++ ) {
            sb.append("#").append(tc).append(" ");
            int n = Integer.parseInt(br.readLine());
            String[][] map = new String[8][8];
            int count = 0;

            for(int i = 0; i < 8; i++) {
                String[] input = br.readLine().split("");
                for(int j = 0; j < 8; j++) map[i][j] = input[j];
            }
            
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j <= 8 - n; j++) {
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    
                    for(int k = 0; k < n; k++) {
                        sb1.append(map[i][j + k]);
                        sb2.append(map[j + k][i]);
                    }
                    
                    String s1 = sb1.toString();
                    String s2 = sb2.toString();

                    String s1r = sb1.reverse().toString();
                    String s2r = sb2.reverse().toString();

                    if(s1.equals(s1r)) count++;
                    if(s2.equals(s2r)) count++;
                }
            }            
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
	}
}