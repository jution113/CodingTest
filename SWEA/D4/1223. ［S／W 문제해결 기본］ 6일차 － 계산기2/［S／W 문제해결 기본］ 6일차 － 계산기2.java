import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= 10; t++ ) {
            int len = Integer.parseInt(br.readLine());
            String input = br.readLine();
            ArrayDeque<Integer> stack = new ArrayDeque<> ();
            stack.push(input.charAt(0) - '0');
            
            for (int i = 1; i < len; i++) {
                char c = input.charAt(i);
                
                if (c == '+') {
                    continue;
                } else if (c == '*') {
                    i++;
                    stack.push(stack.pop() * (input.charAt(i) - '0'));
                } else {
                    stack.push(c - '0');
                }
            }
            
            long res = 0;
            
            while (!stack.isEmpty()) {
                res += stack.pop();
            }
            sb.append("#" + t + " " + res + "\n");
        }
        
        System.out.print(sb.toString());
    }
}