import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] lMinArr = new int[n];
        int[] rMinArr = new int[n];
        int lMin = Integer.MAX_VALUE;
        int rMin = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            lMin = Math.min(a[i], lMin);
            lMinArr[i] = lMin;
            
            rMin = Math.min(a[n - 1 - i], rMin);
            rMinArr[n - 1 - i] = rMin;
        }
        
        int answer = 1;
        
        for (int i = 1; i < n - 1; i++) {
            if (lMinArr[i - 1] < a[i] && rMinArr[i + 1] < a[i]) continue;
            answer++;
        }
        
        return ++answer;
    }
}