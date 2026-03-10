import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987654321;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalNodeCnt = Integer.parseInt(br.readLine());
        int totalEdgeCnt = Integer.parseInt(br.readLine());
        int[][] costTable = new int[totalNodeCnt + 1][totalNodeCnt + 1];
        for (int i = 1; i <= totalNodeCnt; i++) {
            Arrays.fill(costTable[i], INF);
            costTable[i][i] = 0;
        }
        
        StringTokenizer st;
        for (int edgeCnt = 0; edgeCnt < totalEdgeCnt; edgeCnt++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            costTable[start][end] = Math.min(costTable[start][end], cost);
        }
        
        for (int mid = 1; mid <= totalNodeCnt; mid++) {
            for (int start = 1; start <= totalNodeCnt; start++) {
                for (int end = 1; end <= totalNodeCnt; end++) {
                    costTable[start][end] = Math.min(costTable[start][end], costTable[start][mid] + costTable[mid][end]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= totalNodeCnt; i++) {
            for (int j = 1; j <= totalNodeCnt; j++) {
                int node = costTable[i][j];
                if (node == INF)
                    node = 0;
                sb.append(node + " ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}