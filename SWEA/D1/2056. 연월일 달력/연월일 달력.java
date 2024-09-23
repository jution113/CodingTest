import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T  = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] max = new int[13];
        max[1] = 31;
		max[2] = 28;
        max[3] = 31;
        max[4] = 30;
        max[5] = 31;
        max[6] = 30;
        max[7] = 31;
        max[8] = 31;
        max[9] = 30;
        max[10] = 31;
        max[11] = 30;
        max[12] = 31;

        for(int i = 1; i <= T; i++) {
            sb.append("#").append(i).append(" ");
            
            String[] input = br.readLine().split("");
            String year = input[0] + input[1] + input[2] + input[3];
            String month =input[4] + input[5];
			int monthInt = Integer.parseInt(month);
            String day = input[6] + input[7];
            
            if(monthInt <= 12 && Integer.parseInt(day) <= max[monthInt]) {
                sb.append(year).append("/").append(month).append("/").append(day).append("\n");
                continue;
            }
            
            sb.append("-1").append("\n");
        }
        
        System.out.println(sb.toString());
	}
}