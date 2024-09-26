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
            sb.append("#").append(tc);
            String[] input1 = br.readLine().split(" ");
            int N = Integer.parseInt(input1[0]);
            int M = Integer.parseInt(input1[1]);
            
            String[] S = br.readLine().split(" ");
            String[] T = br.readLine().split(" ");
            
            int Q = Integer.parseInt(br.readLine());
            for(int q = 0; q < Q; q++) {
                int year = Integer.parseInt(br.readLine()) - 1;
                String result = "";
                result += N <= year ? S[year % N] : S[year];
                result += M <= year ? T[year % M] : T[year];
                sb.append(" ").append(result);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
	}
}