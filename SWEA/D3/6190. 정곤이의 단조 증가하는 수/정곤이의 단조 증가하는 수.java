import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
            int max  = -1;
            for(int i = 0; i < N - 1; i++) {
                flag:
                for(int j = i + 1; j < N; j++) {
                    int mulNum = nums[i] * nums[j];
                    if(mulNum > 11) {
                        String s = String.valueOf(mulNum);
                        for(int k = 1; k < s.length(); k++) {
                            int num1 = Character.getNumericValue(s.charAt(k - 1));
                            int num2 = Character.getNumericValue(s.charAt(k));
                            if(num2 < num1) continue flag;
                        }
                        max = Math.max(max, mulNum);
                    }
                }
            }
            System.out.println(String.format("#%d %d", tc, max));
        }
        
	}
}