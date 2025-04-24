import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static boolean[][] map;
    static TreeSet<Integer> set = new TreeSet<> ();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            set.add(i);
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u][v] = true;
            map[v][u] = true;
        }
        
        int res = 0;
        while (set.size() > 0) {
            dfs(set.first());
            res++;
        }
        
        System.out.println(res);
    }
    
    static void dfs(int start) {
        set.remove(start);
        
        for (int end = 1; end <= N; end++) {
            if (map[start][end] && set.contains(end)) {
                map[start][end] = false;
                dfs(end);
            }
        }
    }
}
