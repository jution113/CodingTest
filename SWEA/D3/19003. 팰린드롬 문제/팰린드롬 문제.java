import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int result = 0;

            Set<String> totalSet = new HashSet<> ();
            Set<String> palindromeSet = new HashSet<> ();

            for(int i = 0; i < N; i++) totalSet.add(br.readLine());

            boolean findSelfPalindrome = false;
            for(String s : totalSet) {
                String sr = new StringBuilder(s).reverse().toString();

                if(sr.equals(s)) {
                    if(!findSelfPalindrome) {
                        result += M;
                        palindromeSet.add(s);
                        findSelfPalindrome = true;
                    }
                    continue;
                }

                if(totalSet.contains(sr) && !palindromeSet.contains(s) && !palindromeSet.contains(sr)) {
                    result += M * 2;
                    palindromeSet.add(s);
                    palindromeSet.add(sr);
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}