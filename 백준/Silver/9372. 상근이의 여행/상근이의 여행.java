import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCnt = Integer.parseInt(br.readLine());
        final int IDX_OFFEST = 1;

        // 테스트 케이스만큼 반복
        for(int testCase = 0; testCase < testCnt; testCase++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
            for(int i = 0; i < IDX_OFFEST + n; i++) {
                adjList.add(new ArrayList<>());
            }
            boolean[] visited = new boolean[IDX_OFFEST + n];
            int[] result = new int[1] ;
            
            int startIdx = 0;

            // m만큼 반복
            for(int i = 0; i < m; i++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                
                adjList.get(a).add(b);
                adjList.get(b).add(a);

                if(startIdx == 0) startIdx = a;
            }

            dfs(startIdx, result, adjList, visited);
            sb.append(result[0]).append('\n');

        }

        System.out.println(sb);
        
    }

    static void dfs(int startIdx, int[] result, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[startIdx] = true;

        for(int nextNode : adjList.get(startIdx)) {
            if(visited[nextNode]) continue;
            result[0]++;

            dfs(nextNode, result, adjList, visited);
        }
    }
}