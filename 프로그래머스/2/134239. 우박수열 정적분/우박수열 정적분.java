import java.util.*;

class Solution {
    private final int MAX_K_VALUE = 10000;
    
    private int[] graph;
    private double[] size;
    private double[] prefixSumSize;
    private int n;
    
    public double[] solution(int k, int[][] ranges) {
        graph = new int[3 * MAX_K_VALUE];
        prefixSumSize = new double[3 * MAX_K_VALUE];
        n = lotharCollatz(k);
        double[] answer = new double[ranges.length];
        
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int s = range[0];
            int e = n + range[1];
            
            answer[i] = s <= e ? prefixSumSize[e] - prefixSumSize[s] : -1;
        }        
        
        return answer;
    }
    
    private int lotharCollatz(int k) {
        int n = 0;
        
        graph[n++] = k;
        while (k > 1) {
            k = (k & 1) == 0 ? (k / 2) : (k * 3 + 1);
            graph[n] = k;
            prefixSumSize[n] = prefixSumSize[n - 1] + getSize(k, graph[n - 1]);
            n++;
        }
        
        return n - 1;
    }
    
    private double getSize(int y, int y2) {
        int bigger = Math.max(y, y2);
        int smaller = Math.min(y, y2);
        
        return smaller + (bigger - smaller) / 2.0;
    }
}