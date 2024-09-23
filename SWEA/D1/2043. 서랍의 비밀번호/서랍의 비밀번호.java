import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int P = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        System.out.println(P - K  + 1);
	}
}