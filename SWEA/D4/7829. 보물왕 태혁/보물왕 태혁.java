import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int e = Integer.parseInt(st.nextToken());
                min = Math.min(min, e);
                max = Math.max(max, e);
            }
            
            int answer = min * max;
			sb.append("#" + t + " " + answer + "\n");
		}
        
        System.out.println(sb.toString());
	}
}