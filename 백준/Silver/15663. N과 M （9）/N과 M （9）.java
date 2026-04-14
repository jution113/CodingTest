import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static ArrayList<Integer> numList;
    private static HashSet<ArrayList<Integer>> numListSet;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        numList = new ArrayList<> ();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numList);
        
        numListSet = new HashSet<> ();
        sb = new StringBuilder();
        
        permutation(0, new boolean[n], new ArrayList<> ());
        
        System.out.println(sb.toString());
    }
    
    private static void permutation(int depth, boolean[] visit, ArrayList<Integer> peeks) {
        if (depth == m) {
            if (!numListSet.contains(peeks)) {
                numListSet.add(peeks);
                for (int peek : peeks) {
                    sb.append(peek + " ");
                }
                sb.append("\n");
            }
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            peeks.add(numList.get(i));
            permutation(depth + 1, visit, peeks);
            visit[i] = false;
            peeks.remove(peeks.size() - 1);
        }
    }
}