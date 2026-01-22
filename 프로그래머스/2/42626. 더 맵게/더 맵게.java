import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Long> pq = new PriorityQueue<> ();
        
        for (int s : scoville) {
            pq.offer((long) s);
        }
        
        int answer = 0;
        while (!pq.isEmpty()) {
            
            long s1 = pq.poll();
            
            if (s1 >= K) {
                return answer;
            }
            
            if (pq.isEmpty())
                break;
            long sum = s1 + pq.poll() * 2;
            answer++;
            pq.offer(sum);
        }
        
        return -1;
    }
}