import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++) {
            String S = br.readLine();
            StringBuilder E = new StringBuilder(br.readLine());

            while(E.length() > S.length()) {
                // 연산 확인 분기 점검
                if(E.charAt(E.length() - 1) == 'X') {
                    // 1번 연산 확인
                    E.deleteCharAt(E.length() - 1);
                } else {
                    // 2번 연산 확인
                    E.deleteCharAt(E.length() - 1).reverse();
                }
            }

            sb.append("#").append(t).append(" ");
            if(E.toString().equals(S)) {
                sb.append("Yes");
            } else {
                sb.append("No");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}