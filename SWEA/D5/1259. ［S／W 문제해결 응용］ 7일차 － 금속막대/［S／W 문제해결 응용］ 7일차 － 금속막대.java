import java.util.*;
import java.io.*;

class Solution {
    private static ArrayList<Integer> answer;
    private static int N;
    private static int[][] infos;
    
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
		for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            infos = new int[N][2];
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                infos[n][0] = Integer.parseInt(st.nextToken());
                infos[n][1] = Integer.parseInt(st.nextToken());
            }
            answer = new ArrayList<> ();
            dfs(new ArrayList<Integer> (), new boolean[N]);
			sb.append("#" + t);
            for (int n : answer) sb.append(" " + infos[n][0] + " " + infos[n][1]);
			sb.append("\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static void dfs(ArrayList<Integer> peek, boolean[] visited) {
        if (peek.size() > answer.size()) answer= new ArrayList<> (peek);
        if (peek.size() == N) return;
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (peek.size() >= 1 && infos[peek.get(peek.size() - 1)][1] != infos[i][0]) continue;
            visited[i] = true;
            peek.add(i);
            dfs(peek, visited);
            peek.remove(peek.size() - 1);
            visited[i] = false;
        }
    }
}