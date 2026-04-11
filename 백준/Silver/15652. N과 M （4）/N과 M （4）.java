import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int m;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        sb = new StringBuilder();
        
        comb(1, 0, new ArrayList<Integer> ());
        
        System.out.println(sb.toString());
    }
    
    private static void comb(int start, int depth, ArrayList<Integer> peeks) {
        if (depth == m) {
            for (int peek : peeks) {
                sb.append(peek + " ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i <= n; i++) {
            peeks.add(i);
            comb(i, depth + 1, peeks);
            peeks.remove(peeks.size() - 1);
        }
    }
}