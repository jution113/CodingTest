import java.util.*;
import java.io.*;

public class Main {
    static int[] src;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int maxDepth = Integer.parseInt(br.readLine());
        int nodeCnt = (int)Math.pow(2, maxDepth) - 1;
        src = new int[nodeCnt];

        for(int i = 0; i< maxDepth; i++) tree.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < nodeCnt; i++) src[i] = Integer.parseInt(st.nextToken());

        find(0, src.length - 1, 0, maxDepth);

        for(ArrayList<Integer> nodes : tree) {
            for(int node : nodes) {
                sb.append(node).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void find(int start, int end, int depth, int maxDepth) {
        if(depth >= maxDepth) return;

        int centerIdx = (start + end) / 2;
        tree.get(depth).add(src[centerIdx]);
        
        int leftStartIdx = start;
        int leftEndIdx = centerIdx - 1;
        find(leftStartIdx, leftEndIdx, depth + 1, maxDepth);

        int rightStartIdx = centerIdx + 1;
        int rightEndIdx = end;
        find(rightStartIdx, rightEndIdx, depth + 1, maxDepth);
        

    }
}