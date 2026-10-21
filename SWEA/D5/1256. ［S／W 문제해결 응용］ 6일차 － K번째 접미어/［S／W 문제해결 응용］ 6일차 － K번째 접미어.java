import java.util.*;
import java.io.*;

class Solution {
    private static int T;
    
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

		for(int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());
            String word = br.readLine();
            String[] suffixs = new String[word.length()];
            
            for (int i = 0; i < word.length(); i++) {
                suffixs[i] = word.substring(i, word.length());
            }
            
            Arrays.sort(suffixs);            
            sb.append("#" + t + " " + suffixs[K - 1] + "\n");
		}
        System.out.println(sb.toString());
	}
}