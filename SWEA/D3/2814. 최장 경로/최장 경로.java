import java.util.*;
import java.io.*;

class Solution
{
    static int maxPassedVertexCount;
    static int nextStartNodeNum;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Integer>[] list = new ArrayList[N + 1];

            for(int n = 0; n <= N; n++) list[n] = new ArrayList<> ();

            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                list[node1].add(node2);
                list[node2].add(node1);
            }

            nextStartNodeNum = 1;
            while(list[nextStartNodeNum].isEmpty() && N > 1) nextStartNodeNum++;

            maxPassedVertexCount = 0;
            bfs(list, N, nextStartNodeNum, 1);
            bfs(list, N, nextStartNodeNum, 1);

            sb.append(String.format("#%d %d\n", tc, maxPassedVertexCount));
        }
        System.out.println(sb.toString());
    }

    static void bfs(List<Integer>[] list, int N, int startNodeNum, int startMoveCount) {
        Queue<NodeInfo> queue = new LinkedList<> ();
        queue.offer(new NodeInfo(startNodeNum, startMoveCount, new boolean[N + 1]));

        while(!queue.isEmpty()) {
            NodeInfo nodeInfo = queue.poll();
            int nodeNum = nodeInfo.nodeNum;
            int passedVertexCount = nodeInfo.passedVertexCount;
            boolean[] visited = Arrays.copyOf(nodeInfo.visited, N + 1);
            visited[nodeNum] = true;

            if(passedVertexCount > maxPassedVertexCount) {
                maxPassedVertexCount = passedVertexCount;
                nextStartNodeNum = nodeNum;
            }

            for(int i = 0; i < list[nodeNum].size(); i++) {
                int nextNodeNum = list[nodeNum].get(i);
                if(visited[nextNodeNum]) continue;
                queue.offer(new NodeInfo(nextNodeNum, passedVertexCount + 1, visited));
            }
        }
    }

    static class NodeInfo {
        int nodeNum;
        int passedVertexCount;
        boolean[] visited;

        public NodeInfo(int nodeNum, int passedVertexCount, boolean[] visited) {
            this.nodeNum = nodeNum;
            this.passedVertexCount = passedVertexCount;
            this.visited = visited;
        }
    }
}
