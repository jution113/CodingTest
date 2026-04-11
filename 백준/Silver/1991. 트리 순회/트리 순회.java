import java.io.*;
import java.util.*;

public class Main {
    private static HashMap<Character, char[]> tree;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        tree = new HashMap<> ();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            
            tree.put(p, new char[] {r, l});
        }
        
        sb = new StringBuilder();
        
        preOrder('A');
        sb.append("\n");
        inOrder('A');
        sb.append("\n");
        postOrder('A');
        
        System.out.println(sb.toString());
    }
    
    private static void preOrder(char start) {
        sb.append(start);
        
        char[] children = tree.get(start);
        char r = children[0];
        char l = children[1];
        
        if (r != '.') preOrder(r);
        if (l != '.') preOrder(l);
    }
    
    private static void inOrder(char start) {
        char[] children = tree.get(start);
        char r = children[0];
        char l = children[1];
        
        if (r != '.') inOrder(r);
        sb.append(start);
        if (l != '.') inOrder(l);   
    }
    
    private static void postOrder(char start) {        
        char[] children = tree.get(start);
        char r = children[0];
        char l = children[1];
        
        if (r != '.') postOrder(r);
        if (l != '.') postOrder(l);
        sb.append(start);
    }
}