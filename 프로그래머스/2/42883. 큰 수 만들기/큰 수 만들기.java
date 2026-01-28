import java.util.*;

class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Integer> st = new ArrayDeque<> ();
        int cnt = 0;
        
        for (char c : number.toCharArray()) {
            int n = c - '0';
            
            while (!st.isEmpty() && st.peek() < n && cnt < k) {
                st.pop();
                cnt++;
            }
            
            st.push(n);
        }
        
        while (!st.isEmpty() && cnt < k) {
            st.pop();
            cnt++;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(String.valueOf(st.pop()));
        }
        return sb.reverse().toString();
    }
}