import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int m;
    private static ArrayList<Integer>[] partyListByMan;
    private static ArrayList<Integer>[] manListByParty;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        if (k == 0) {
            System.out.println(m);
            return;
        }

        int[] kMan = new int[k];
        for (int i = 0; i < k; i++) {
            kMan[i] = Integer.parseInt(st.nextToken());
        }
        
        manListByParty = new ArrayList[m + 1];
        partyListByMan = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            partyListByMan[i] = new ArrayList<> ();
        }

        for (int p = 1; p <= m; p++) {
            manListByParty[p] = new ArrayList<> ();
            st = new StringTokenizer(br.readLine());

            int totalMan = Integer.parseInt(st.nextToken());
            
            for (int i = 0; i < totalMan; i++) {
                int man = Integer.parseInt(st.nextToken());
                manListByParty[p].add(man);
                partyListByMan[man].add(p);
            }
        }
        
        System.out.println(bfs(kMan));
    }
    
    private static int bfs(int[] kMan) {
        ArrayDeque<Integer> que = new ArrayDeque<> ();
        boolean[] visitParty = new boolean[m + 1];
        int visit = 0;
        
        for (int man : kMan) {
            for (int party : partyListByMan[man]) {
                if (visitParty[party]) continue;
                que.offer(party);
                visitParty[party] = true;
                visit++;
            }
        }
        
        while (!que.isEmpty()) {
            int party = que.poll();
            
            for (int man : manListByParty[party]) {
                for (int nParty : partyListByMan[man]) {
                    if (visitParty[nParty]) continue;
                    que.offer(nParty);
                    visitParty[nParty] = true;
                    visit++;
                }
            }
        }
        
        return m - visit;
    }
}