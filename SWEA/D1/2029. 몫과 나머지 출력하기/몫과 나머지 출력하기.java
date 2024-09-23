import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = "";
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= T; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

            result += String.format("#%d %d %d\n", i, a / b, a% b);
        }
        
        System.out.println(result);
	}
}