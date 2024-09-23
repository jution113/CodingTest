import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int centerIdx = Integer.parseInt(br.readLine()) / 2;
        List<Integer> nums = new ArrayList<> ();
        for(String num : br.readLine().split(" ")) nums.add(Integer.parseInt(num));
        Collections.sort(nums);
        System.out.println(nums.get(centerIdx));
	}
}