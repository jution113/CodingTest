import java.util.*;
import java.io.*;

class Solution
{
    static int N;
    static int K;
    static List<Integer> arr;
    static int result;
    
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arr = new ArrayList<> ();
            while(st.hasMoreTokens()) arr.add(Integer.parseInt(st.nextToken()));
            
            result = 0;
            for(int i = 1; i <= N; i++) makeCombination(0, 0, i, 0);

            sb.append(String.format("#%d %d\n", tc, result));
        }
        System.out.println(sb.toString());
    }
    
    static void makeCombination(int start, int curDepth, int maxDepth, int sum) {
        if(curDepth == maxDepth) {
            if(sum == K) result++;
            return;
        }
        
        for(int i = start; i < N; i++) {
            makeCombination(i + 1, curDepth + 1, maxDepth, sum + arr.get(i));
        }
    }
}