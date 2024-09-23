import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= T; i++) {
            sb.append("#").append(i).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if(num > max) max = num;
            }
            
            sb.append(max).append("\n");
        }

        System.out.println(sb.toString());
	}
}