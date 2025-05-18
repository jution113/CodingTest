import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int last = 0;
    static Stack<Integer> st = new Stack<> ();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            if (last < target) {
                for (int j = last + 1; j <= target; j++) {
                    st.add(j);
                    sb.append("+").append("\n");
                }
                st.pop();
                sb.append("-").append("\n");
                last = target;
            } else {
                while (!st.isEmpty() && st.peek() != target) {
                    st.pop();
                    sb.append("-").append("\n");
                }
                if (st.isEmpty()) {
                    System.out.println("NO");
                    System.exit(0);
                }
                st.pop();
                sb.append("-").append("\n");
            }
        }
        System.out.println(sb);
    }
}