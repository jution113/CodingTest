import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeSize = Integer.parseInt(st.nextToken());
        
        graph = new int[nodeSize][2];
        
        for (int i = 0; i < nodeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            
            String leftStr = st.nextToken();
            int left = leftStr.equals(".") ? -1 : leftStr.charAt(0) - 'A';
            
            String rightStr = st.nextToken();
            int right = rightStr.equals(".") ? -1 : rightStr.charAt(0) - 'A';
            
            graph[parent][0] = left;
            graph[parent][1] = right;
        }
        
        StringBuilder sb = new StringBuilder();
        preOrder(0, sb);
        sb.append("\n");
        inOrder(0, sb);
        sb.append("\n");
        postOrder(0, sb);
        sb.append("\n");
        
        System.out.println(sb.toString());
    }
    
    private static void preOrder(int parent, StringBuilder sb) {
        char c = (char) (65 + parent);
        sb.append(c);
        
        if (graph[parent][0] != -1) {
            preOrder(graph[parent][0], sb);
        }
        
        if (graph[parent][1] != -1) {
            preOrder(graph[parent][1], sb);
        }
    }
    
    private static void inOrder(int parent, StringBuilder sb) {
        if (graph[parent][0] != -1) {
            inOrder(graph[parent][0], sb);
        }
        
        char c = (char) (65 + parent);
        sb.append(c);
        
        if (graph[parent][1] != -1) {
            inOrder(graph[parent][1], sb);
        }
    }
    
    private static void postOrder(int parent, StringBuilder sb) {
        if (graph[parent][0] != -1) {
            postOrder(graph[parent][0], sb);
        }
        
        if (graph[parent][1] != -1) {
            postOrder(graph[parent][1], sb);
        }
        
        char c = (char) (65 + parent);
        sb.append(c);
    }
}