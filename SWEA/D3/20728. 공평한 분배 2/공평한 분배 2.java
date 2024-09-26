import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            String[] input1 = br.readLine().split(" ");
            int N = Integer.parseInt(input1[0]);
            int K = Integer.parseInt(input1[1]);

            int[] arr = new int[N];
            String[] input2 = br.readLine().split(" ");
            for(int i  = 0; i < N; i++) arr[i] = Integer.parseInt(input2[i]);
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            
            for(int i = 0; i <= N - K; i++) {
                int gap = arr[i + K - 1] - arr[i];
                if(min > gap) min = gap;
            }

            sb.append(min).append("\n");
        }
        System.out.println(sb.toString());
    }
}