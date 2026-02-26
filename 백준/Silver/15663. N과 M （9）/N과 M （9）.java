import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] src;
    static boolean[] visited;
    static HashSet<ArrayList<Integer>> uniqueListSet;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        src = new int[N];
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(src);
        visited = new boolean[N];
        uniqueListSet = new HashSet<> ();
        
        comb(0, new ArrayList<> ());
    }
    
    private static void comb(int depth, ArrayList<Integer> list) {
        if (depth == M) {
            if (!uniqueListSet.contains(list)) {
                uniqueListSet.add(list);
                StringBuilder sb = new StringBuilder ();
                for (int e : list) {
                    sb.append(e + " ");
                }
                sb.delete(sb.length() - 1, sb.length());
                
                System.out.println(sb.toString());
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(src[i]);
                comb(depth + 1, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}