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
            String S = br.readLine();
            int n = S.length();
            String answer = "";

            // 회문 체크: 좌변 -> 전체
            if(palindromeCheck(S, 0, n / 2) && palindromeCheck(S, 0, n)) {
                answer = "YES";
            } else {
                answer = "NO";
            }
            
            sb.append(answer).append("\n");
        }
        
        System.out.println(sb.toString());
	}
    
    static boolean palindromeCheck(String src, int start, int end) {
        int length = end - start;
        int center = length / 2;
        
        StringBuilder left = new StringBuilder(src.substring(start, center));
        String right = length % 2 == 0 ? src.substring(center, end) : src.substring(center + 1, end);
		return right.equals(left.reverse().toString());
    }
}