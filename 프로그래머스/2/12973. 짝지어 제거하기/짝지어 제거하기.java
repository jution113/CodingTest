import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Integer> st = new Stack<> ();
        st.push(s.charAt(0) - '0');
        
        for (int i = 1; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            
            if (!st.empty() && st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }

        return st.empty() ? 1 : 0;
    }
}