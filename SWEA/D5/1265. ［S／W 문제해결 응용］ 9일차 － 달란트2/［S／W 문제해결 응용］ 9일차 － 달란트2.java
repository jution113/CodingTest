import java.util.*;
import java.io.*;

class Solution {
    private static int T = 10;
    
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder(); 
        T= Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            
            long a = N / P;
            long answer = (long) Math.pow(a, P - N % P) * (long) Math.pow(a + 1, N % P);
            
			sb.append("#" + t + " " + answer + "\n");
		}
        
        System.out.println(sb.toString());
	}
}