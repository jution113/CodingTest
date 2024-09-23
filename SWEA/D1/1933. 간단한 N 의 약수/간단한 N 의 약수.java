import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= T; i++) {
            if(T % i == 0) sb.append(i).append(" ");
        }
        
        System.out.println(sb.toString());
	}
}