import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("#").append(i).append(" ");

			double sum = 0;

            while(st.hasMoreTokens()) sum += Integer.parseInt(st.nextToken());

            sb.append(Math.round(sum / 10)).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}