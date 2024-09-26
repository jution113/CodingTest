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
            String[] src = br.readLine().split(" ");            
            int A = Integer.parseInt(src[0]);
			int B = Integer.parseInt(src[1]);
			int C = Integer.parseInt(src[2]);
			int sum = 0;
            sb.append("#").append(t).append(" ");

            if(1 <= A && 2 <= B && 3 <= C) {
                int eat = 0;
                
                if(B >= C) {
                    eat = B - (C - 1);
                    B -= eat;
                    sum += eat;
                }
                
                if(A >= B) {
                    eat = A - (B - 1);
                    A -= eat;
                    sum += eat;
                }
                
            } else {
                sum = -1;
            }
            
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
	}
}