import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
        
		for(int t= 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            String answer = validate(N, M) ? "ON" : "OFF";
            sb.append("#" + t + " " + answer + "\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static boolean validate(int N, int M) {
        String bStr = Integer.toBinaryString(M);
        if (N > bStr.length()) return false;
        for (int i = bStr.length() - N; i < bStr.length(); i++)
            if (bStr.charAt(i) == '0') return false;
        return true;
    }
}