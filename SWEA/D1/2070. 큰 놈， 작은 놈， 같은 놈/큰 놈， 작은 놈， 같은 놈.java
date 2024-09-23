import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= T; i++) {
            sb.append("#").append(i).append(" ");
            
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if(a > b) {
                sb.append(">");
            } else if(a < b) {
				sb.append("<");
            } else {
				sb.append("=");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}