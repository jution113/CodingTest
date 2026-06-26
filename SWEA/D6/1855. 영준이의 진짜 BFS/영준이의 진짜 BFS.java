import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 트리 초기화
            int[] parentInfo = new int[N + 1];
            parentInfo[0] = -1;
            ArrayList<Integer>[] tree = new ArrayList[N + 1];
            for (int n = 1; n <= N; n++) tree[n] = new ArrayList<> ();
            for (int n = 2; n <= N; n++) {
                int parent = Integer.parseInt(st.nextToken());
                tree[parent].add(n);
                parentInfo[n] = parent;
            }
            
            sb.append("#" + tc + " " + bfs(tree, parentInfo, N) + "\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static long bfs(ArrayList<Integer>[] tree, int[] parentInfo, int N)  {
        int[] levelInfo = new int[N + 1];
        levelInfo[0] = 1;
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        que.offer(new int[] {1, 1});
        ArrayList<Integer> path = new ArrayList<> ();
        long disSum = 0;
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            
            levelInfo[cur[0]] = cur[1] + 1;
            path.add(cur[0]);
            for (int next : tree[cur[0]]) que.offer(new int[] {next, cur[1] + 1});
        }
        
        for (int i = 0; i < path.size() - 1; i++) disSum += getDis(path.get(i), path.get(i + 1), tree, levelInfo, parentInfo);
        
        return disSum;
    }
    
    private static int getDis(int start, int end, ArrayList<Integer>[] tree, int[] levelInfo, int[] parentInfo) {
        int dis = 0;
        
        while (levelInfo[start] != levelInfo[end]) {
            if (levelInfo[start] > levelInfo[end]) {
                start = parentInfo[start];
            } else {
                end = parentInfo[end];
            }
            dis++;
        }
        
        while (start != end) {
            start = parentInfo[start];
            end = parentInfo[end];
            dis += 2;
        }
        
        return dis;
    }
}