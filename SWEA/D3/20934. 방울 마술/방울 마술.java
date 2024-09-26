import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
      	int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            String[] S = br.readLine().split(" ");
            int loc = S[0].indexOf("o");
            int K = Integer.parseInt(S[1]);
            
            if(K == 0) {
                sb.append(loc);
            } else if(K % 2 == 0) {
                if(loc == 1) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            } else {
                if(loc == 1) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
	}
}