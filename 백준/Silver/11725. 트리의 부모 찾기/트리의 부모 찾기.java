import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        final int IDX_OFFSET = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int nodeCnt = Integer.parseInt(br.readLine());

        // 인접 리스트 생성
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i <= nodeCnt; i ++) {
            // 인덱스를 활용하여 1부터 접근하기 위해 0 추가
            adjList.add(new ArrayList<>());
        }
        
        for(int i = IDX_OFFSET + 1; i <= nodeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());

            adjList.get(input1).add(input2);
            adjList.get(input2).add(input1);
        }

        // 노드의 부모 저장 배열
        int[] parentsInfo = findParent(nodeCnt, adjList);

        
        for(int i = IDX_OFFSET + 1; i <= nodeCnt; i++) {
            sb.append(parentsInfo[i]).append('\n');
        }

        System.out.print(sb);
    }

    static int[] findParent(int nodeCnt, ArrayList<ArrayList<Integer>> adjList) {
        final int IDX_OFFSET = 1;
        final int DEFAULT_ROOT_VALUE = 1; 

        // 방문 여부 검사 배열
        boolean[] visited = new boolean[IDX_OFFSET + nodeCnt];
        // 노드의 부모 저장 배열
        int[] parentsInfo = new int[IDX_OFFSET + nodeCnt];

        Queue<Integer> que = new LinkedList<>();

        que.add(DEFAULT_ROOT_VALUE);
        visited[DEFAULT_ROOT_VALUE] = true;

        while(!que.isEmpty()) {
            int node = que.poll();
            
            for(int child : adjList.get(node)) {
                if(visited[child]) continue;
                que.add(child);
                visited[child] = true;
                parentsInfo[child] = node;
            }
        }

        return parentsInfo;
    }
}