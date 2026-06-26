import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            int aLen = a.length();
            int bLen = b.length();
            int aIdx =  a.length() - 1;
            int bIdx =  b.length() - 1;
            StringBuilder sb2 = new StringBuilder();
           	int round = 0;
            
            while (aIdx >= 0 && bIdx >= 0) {
                int digit = a.charAt(aIdx--) - '0' + b.charAt(bIdx--) - '0' + round;
                
                if (digit >= 10) {
                    digit -= 10;
                    round = 1;
                } else {
                    round = 0;
                }
                
                sb2.append(digit);
            }
            
            if (aIdx >= 0) {
                for (; aIdx >= 0; aIdx--) {
                    int digit = a.charAt(aIdx) - '0' + round;
                    if (digit >= 10) {
                        digit -= 10;
                        round = 1;
                    } else {
                        round = 0;
                    }
                    sb2.append(digit);
                }
            } else if (bIdx >= 0) {
                for (; bIdx >= 0; bIdx--) {
                    int digit = b.charAt(bIdx) - '0' + round;
                    if (digit >= 10) {
                        digit -= 10;
                        round = 1;
                    } else {
                        round = 0;
                    }
                    sb2.append(digit);
                }
            }
            
            if (round == 1) sb2.append('1');
            
            sb.append("#" + tc + " " + sb2.reverse().toString() + "\n");
		}
        
        System.out.println(sb.toString());
	}
}