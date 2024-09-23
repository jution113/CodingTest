import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(String num : br.readLine().split("")) sum += Integer.parseInt(num);
        System.out.println(sum);
	}
}