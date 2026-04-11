import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static int[] src;
    private static boolean[] used;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        
        // n개의 수들을 담을 배열 초기화
        src = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(src);
        
        used = new boolean[n];
        
        comb(0, new ArrayList<Integer> ());
        
        System.out.println(sb.toString());
    }
    
    private static void comb(int depth, ArrayList<Integer> peeks) {
        if (depth == m) {
            for (int peek : peeks) {
                sb.append(peek + " ");
            }
            sb.append("\n");
            return ;
        }
        
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            
            peeks.add(src[i]);
            used[i] = true;
            
            comb(depth + 1, peeks);
            
            peeks.remove(peeks.size() - 1);
            used[i] = false;
        }
    } 
}