import java.util.*;

class Solution {
    private class NodeInfo {
        int num;
        int y;
        int x;
        
        public NodeInfo(int num, int y, int x) {
            this.num = num;
            this.y = y;
            this.x = x;
        }
    }
    
    private class Node {
        int num;
        int x;
        Node left = null;
        Node right = null;
        
        public Node (int num, int x) {
            this.num = num;
            this.x = x;
        }
    }
    
    private class Tree {
        Node root;
        
        public Tree(Node root) {
            this.root = root;
        }
        
        private void add(Node parent, Node node) {
            if (node.x < parent.x) {
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    add(parent.left, node);
                }
            } else {
                if (parent.right == null) {
                    parent.right = node;
                } else {
                    add(parent.right, node);
                }
            }
        }
        
        private void preOrder(Node node, ArrayList<Integer> path) {
            path.add(node.num);
            if (node.left != null) preOrder(node.left, path);
            if (node.right != null) preOrder(node.right, path);
        }
        
        private void postOrder(Node node, ArrayList<Integer> path) {
            if (node.left != null) postOrder(node.left, path);
            if (node.right != null) postOrder(node.right, path);
            path.add(node.num);
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        // node 정보 정렬
        PriorityQueue<NodeInfo> pq = new PriorityQueue<> ((a, b) -> {
            return Integer.compare(b.y, a.y);
        });
        for (int i = 0; i < nodeinfo.length; i++) {
            int num = i + 1;
            int y = nodeinfo[i][1];
            int x = nodeinfo[i][0];
            pq.offer(new NodeInfo(num, y, x));
        }
        
        // 트리 구축
        NodeInfo rootInfo = pq.poll();
        Tree tree = new Tree(new Node(rootInfo.num, rootInfo.x));
        
        while (!pq.isEmpty()) {
            NodeInfo nodeInfo = pq.poll();
            tree.add(tree.root, new Node(nodeInfo.num, nodeInfo.x));
        }
        
        // 순회
        ArrayList<Integer> preOrderPath = new ArrayList<> ();
        ArrayList<Integer> postOrderPath = new ArrayList<> ();
        
        tree.preOrder(tree.root, preOrderPath);
        tree.postOrder(tree.root, postOrderPath);

        int[][] answer = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preOrderPath.get(i);
            answer[1][i] = postOrderPath.get(i);
        }
        
        return answer;
    }
}