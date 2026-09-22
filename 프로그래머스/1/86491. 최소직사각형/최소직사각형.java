import java.util.*;

class Solution {
    private int wide;
    private int height;
    
    public int solution(int[][] sizes) {
        int n = sizes.length;
        int[] wides = new int[n];
        int[] heights = new int[n];
        
        for (int i = 0; i < sizes.length; i++) {
            wides[i] = sizes[i][0];
            heights[i] = sizes[i][1];
        }
        
        Arrays.sort(wides);
        Arrays.sort(heights);
        
        wide = Math.max(wides[n - 1], heights[n - 1]);
        height = 0;

        for (int[] size : sizes) {
            int w = size[0];
            int h = size[1];
            
            if (validateSize(w, h))
                continue;
            
            height = Math.min(w, h);
        }
        
        return wide * height;
    }
    
    private boolean validateSize(int w, int h) {
        return h <= height || w <= height;
    }
}