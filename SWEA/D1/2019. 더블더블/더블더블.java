import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int num = 1;
        
        for(int i = 0; i < T; i++) {
            sb.append(num).append(" ");
            num *= 2;
        }
        sb.append(num);
        
        System.out.println(sb.toString());
	}
}