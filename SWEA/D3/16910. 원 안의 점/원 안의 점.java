import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            int result = 0;
            for(int i = -N; i <= N; i++) {
                for(int j = -N; j <= N; j++) {
                    if(Math.pow(i, 2) + Math.pow(j, 2) <= Math.pow(N, 2)) result++;
                }
            }
            System.out.println(String.format("#%d %d", tc, result));
        }
	}
}