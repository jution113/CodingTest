import java.util.*;
import java.io.*;

class Solution
{
    static int numSize = 8;
    static int countLimit = 5;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= 10; tc++) {
            int TC = Integer.parseInt(br.readLine());
            sb.append("#").append(TC).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] nums = new int[numSize];
            for(int i = 0; i < numSize; i++) nums[i] = Integer.parseInt(st.nextToken());
            int idx = 0;
            int count = 1;
            while(true) {
                nums[idx] -= count;
                if(nums[idx] < 1) {
                    nums[idx] = 0;
                    idx = (idx + 1) % numSize;
                    break;
                }
                count = count + 1 > countLimit ? 1 : count + 1;
                idx = (idx + 1) % numSize;
            }
            for(int i = 0; i < numSize; i++) sb.append(nums[(idx + i) % numSize]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}