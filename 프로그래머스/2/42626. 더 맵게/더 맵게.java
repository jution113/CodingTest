import java.util.*;

class Solution {
    private int K;
    private PriorityQueue<Integer> orderedScoville;
    
    public int solution(int[] scoville, int K) {
        this.K = K;
        orderedScoville = new PriorityQueue<> ();
        
        initOrderedScoville(scoville);
        
        return combine();
    }
    
    private void initOrderedScoville(int[] scoville) {
        for (int s : scoville) {
            orderedScoville.offer(s);
        }
    }
    
    private int combine() {
        int combCnt = 0;
        
        while (!orderedScoville.isEmpty()) {
            int scoville1 = orderedScoville.poll();
            
            if (scoville1 >= K)
                break;
            
            if (orderedScoville.isEmpty())
                return -1;
            
            int scoville2 = orderedScoville.poll();

            if (scoville2 >= K) {
                combCnt++;
                break;
            } else {
                orderedScoville.offer(combScoville(scoville1, scoville2));
                combCnt++;
            }
        }
        
        return combCnt;
    }
    
    private int combScoville(int scoville1, int scoville2) {
        return scoville1 + scoville2 * 2;
    }
}