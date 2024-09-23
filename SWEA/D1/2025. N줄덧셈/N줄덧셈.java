import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int sum = 0;
        
        for(int i = 1; i <= T; i++) {
			sum += i;
        }
        
        System.out.println(sum);
	}
}