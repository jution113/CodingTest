// root가 0이라는 보장은 없다
// child가 2개라는 보장은 없다

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int ROOT_PARENT_IDX = -1;

        int n = Integer.parseInt(br.readLine());

        String[] parent = br.readLine().split(" ");

        int target = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n];
        Tree tree =  new Tree();

        for(int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < n; i++) {
            int parentIdx = Integer.parseInt(parent[i]);
            if(i == target || parentIdx == target) continue;

            Node node = nodes[i];

            if(parentIdx == ROOT_PARENT_IDX) {
                // 루트 설정
                tree.root = node;
            } else {
                // 자식으로 설정
                if(nodes[parentIdx] == null) nodes[parentIdx] = new Node(parentIdx);
                nodes[parentIdx].child.add(node);
            }
        }
        int result = 0;
        if(tree.root != null) {
            if(target != tree.root.data) result = tree.findLeafCnt(nodes);
        }

        System.out.print(result);
        
    }
}

class Node {
    int data;
    ArrayList<Node> child = new ArrayList<> ();

    public Node(int data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    int findLeafCnt(Node[] nodes) {
        int leafCnt = 0;

        boolean[] visited = new boolean[nodes.length];

        Queue<Node> queue = new LinkedList<> ();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node visitedNode = queue.poll();
            visited[visitedNode.data] = true;
            

            if(visitedNode.child == null || visitedNode.child.size() == 0) {
                leafCnt++;
                continue;
            }

            for(Node child : visitedNode.child) {
                if(child == null) continue;
                if(!visited[child.data]) queue.add(child);
            }

        }

        return leafCnt;

    }
}