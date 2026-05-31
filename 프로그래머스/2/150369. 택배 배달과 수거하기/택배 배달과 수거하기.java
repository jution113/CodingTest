import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int dPtr = n - 1;
        int pPtr = n - 1;
        while (dPtr >= 0 && deliveries[dPtr] == 0) dPtr--;
        while (pPtr >= 0 && pickups[pPtr] == 0) pPtr--;
        
        long disSum = 0;
        
        while (dPtr >= 0 || pPtr >= 0) {
            int d = cap;
            int p = cap;
            int dis = Math.max(dPtr, pPtr) + 1;
            disSum += dis * 2;
            
            while (d >= 0 && dPtr >= 0) {
                if (deliveries[dPtr] == 0) {
                    dPtr--;
                    continue;
                }
                    
                if (deliveries[dPtr] > d) {
                    deliveries[dPtr] -= d;
                    break;
                }
                    
                d -= deliveries[dPtr];
                deliveries[dPtr] = 0;
                dPtr--;
            }
                
            while (p >= 0 && pPtr >= 0) {
                if (pickups[pPtr] == 0) {
                    pPtr--;
                    continue;
                }
                    
                if (pickups[pPtr] > p) {
                    pickups[pPtr] -= p;
                    break;
                }
                    
                p -= pickups[pPtr];
                pickups[pPtr] = 0;
                pPtr--;
            }
            
        }
        
        return disSum;
    }
}