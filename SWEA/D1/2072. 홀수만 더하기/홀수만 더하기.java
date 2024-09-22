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
            sb.append(String.format("#%d ", i));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 == 1) sum += num;
            }
            sb.append(sum + "\n");
        }
        
        System.out.println(sb.toString());
	}
}