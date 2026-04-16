import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static int minDisSum;
    private static ArrayList<int[]> homeList;
    private static ArrayList<int[]> chickenList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        homeList = new ArrayList<> ();
        chickenList = new ArrayList<> ();
        
        // map 초기화
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            
            for (int x = 0; x < n; x++) {
                int i = Integer.parseInt(st.nextToken());
                
                if (i == 1) {
                    homeList.add(new int[] {y, x});
                } else if (i == 2) {
                    chickenList.add(new int[] {y, x});
                }
            }
        }
        
        minDisSum = Integer.MAX_VALUE;
        comb(0, 0, new ArrayList<int[]> ());
        
        System.out.println(minDisSum);
    }
    
    private static void comb(int start, int depth, ArrayList<int[]> peeks) {
        if (depth == m) {
            minDisSum = Math.min(minDisSum, getDisSum(peeks));
            return;
        }
        
        for (int i = start; i < chickenList.size(); i++) {
            peeks.add(chickenList.get(i));
            comb(i + 1, depth + 1, peeks);
            peeks.remove(peeks.size() - 1);
        }
    }
    
    private static int getDisSum(ArrayList<int[]> peeks) {
        int disSum = 0;
        
        for (int[] home : homeList) {
            int minDis = Integer.MAX_VALUE;
            
            for (int[] chicken : peeks) {
                minDis = Math.min(minDis,  Math.abs(chicken[0] - home[0]) + Math.abs(chicken[1] - home[1]));
            }
            disSum += minDis;
        }
        
        return disSum;
    }
}