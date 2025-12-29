import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        Stack st = new Stack();
        
        for (char c : s.toCharArray()) {
            if (c == '(')
                st.push(1);
            else {
                if (st.empty())
                    return false;
                else
                    st.pop();
            }
        }
        
        return st.isEmpty();
    }
}