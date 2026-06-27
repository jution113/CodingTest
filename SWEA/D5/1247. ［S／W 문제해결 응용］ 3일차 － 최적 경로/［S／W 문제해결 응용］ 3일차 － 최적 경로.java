import java.util.*;
import java.io.*;

class Solution {
    private static int N;
    private static int[][] posInfo;
    private static int answer;
    
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
		for(int tc = 1; tc <= T; tc++) {
            answer = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            posInfo = new int[N + 2][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N + 2; n++) {
                posInfo[n][0] = Integer.parseInt(st.nextToken());
                posInfo[n][1] = Integer.parseInt(st.nextToken());
            }
            
            makePermutation(new ArrayList<> (Arrays.asList(0)), new boolean[N]);
            sb.append("#" + tc + " " + answer + "\n" );
		}
        
        System.out.println(sb.toString());
	}
    
    private static void makePermutation(ArrayList<Integer> permutation, boolean[] visited) {
        if (permutation.size() == N + 1) {
            permutation.add(1);
            answer = Math.min(answer, calculrateDis(permutation));
            permutation.remove(permutation.size() - 1);
            return;
        }
         
        for (int n = 0; n < N; n++) {
            if (visited[n]) continue;
            visited[n] = true;
            permutation.add(2 + n);
            makePermutation(permutation, visited);
            permutation.remove(permutation.size() - 1);
            visited[n] = false;
        }
    }
    
    private static int calculrateDis(ArrayList<Integer> permutation) {        
        int disSum = 0;
        
        for (int n = 0; n < permutation.size() - 1; n++) {
            int s = permutation.get(n);
            int e = permutation.get(n + 1);
            
            disSum += Math.abs(posInfo[s][0] - posInfo[e][0]) + Math.abs(posInfo[s][1] - posInfo[e][1]);
        }
        
        return disSum;
    } 
}