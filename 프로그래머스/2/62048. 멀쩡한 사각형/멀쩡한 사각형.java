import java.util.*;

class Solution {
    public long solution(int w, int h) {
        int div = h / w;
        int mod = h % w;
        int[] prevY = {0, 0};
        int[] y = {div, mod};
        long answer = 0;
        
        for (int x = 1; x <= w; x++) {
            int remove = y[0] - prevY[0];
            if (y[1] > 0) remove++;
            answer += h - remove;
            
            prevY = Arrays.copyOf(y, 2);
            
            y[1] += mod;
            if (y[1] >= w) {
                y[0] += y[1] / w;
                y[1] %= w;
            }
            y[0] += div;
        }
        
        return answer;
    }
}