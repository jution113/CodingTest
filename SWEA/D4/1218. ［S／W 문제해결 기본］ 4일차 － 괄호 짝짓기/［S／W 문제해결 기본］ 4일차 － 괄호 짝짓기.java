import java.util.*;
import java.io.*;

class Solution {
    private static final int TOTAL_TEST_CASE = 10;
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int len;
    private static String brackets;
    
	public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        
		for(int testCase = 1; testCase <= TOTAL_TEST_CASE; testCase++) {
            initData();
            int answer = validateBrackets() ? 1 : 0;
            sb.append("#" + testCase + " " + answer + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void initData() throws IOException {
        len = Integer.parseInt(br.readLine());
        brackets = br.readLine();
    }
    
    private static boolean validateBrackets() {
        ArrayDeque<Character> st = new ArrayDeque<> ();
        
        for (int i = 0; i < len; i++) {
            char c = brackets.charAt(i);

            switch (c) {
                case ']':
		            if (!st.isEmpty() && st.peek() == '[')
                        st.pop();
                    else
	            		st.push(c);
                    break;
                case '}':
		            if (!st.isEmpty() && st.peek() == '{')
                        st.pop();
                    else 
	            		st.push(c);
                    break;
                case ')':
	    	        if (!st.isEmpty() && st.peek() == '(')
                        st.pop();
					else
	            		st.push(c);
                    break;
                case '>':
	    	        if (!st.isEmpty() && st.peek() == '<')
                        st.pop();
                    else
	            		st.push(c);
                    break;
                default:
            		st.push(c);
            }
        }
        return st.isEmpty();
    }
}