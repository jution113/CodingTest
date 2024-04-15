import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String src = br.readLine();
        String target = br.readLine();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            st.push(c);

            if(st.size() >= target.length()) {
                for(int j = 0; j < target.length(); j++) {
                    if(st.get(st.size() - target.length() + j) != target.charAt(j)) break;
                    if(j == target.length() - 1) {
                        for(int k = 0; k < target.length(); k++) {
                            st.pop();
                        }
                    }
                }
            }
        }

        StringBuilder sb;

        if(!st.isEmpty()) {
            sb = new StringBuilder();

            while(!st.isEmpty()) {
                sb.append(st.pop());
            }
            sb.reverse();
        } else {
            sb = new StringBuilder("FRULA");
        }

        System.out.println(sb);
    }
}