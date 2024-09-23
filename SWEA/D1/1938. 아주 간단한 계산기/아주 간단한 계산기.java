import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        
        sb.append(a + b).append("\n");
		sb.append(a - b).append("\n");
		sb.append(a * b).append("\n");
        sb.append(a % b);

        System.out.println(sb.toString());
	}
}