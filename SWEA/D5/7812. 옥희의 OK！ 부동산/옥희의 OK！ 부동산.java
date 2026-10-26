import java.util.*;
import java.io.*;

class Solution {
    private static int n;
    private static int budget;
    private static int[] lands;
    
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for(int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			budget = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            lands = new int[n];
            for (int i = 0; i < n; i++) lands[i] = Integer.parseInt(st.nextToken());
            
            sb.append("#" + t + " " + getPortfolioCnt() + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static int getPortfolioCnt() {
        int portfolioCnt = 0;
        int costSum = 0;
        int j = 0;
        
        for (int i = 0; i < n; i++) {
            costSum += lands[i];
            
            if (costSum == budget) portfolioCnt++;
            
            while (costSum > budget) {
                costSum -= lands[j++];
                if (costSum == budget) portfolioCnt++;
            }
        }
        
        return portfolioCnt;
    }
}