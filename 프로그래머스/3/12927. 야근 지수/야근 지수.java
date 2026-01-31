import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<> ((a, b) -> b - a);
        
        for (int i = 0; i < works.length ; i++) {
            pq.offer(works[i]);
        }
        
        int i = 0;
        while (i < n && !pq.isEmpty()) {
            int num = pq.poll() - 1;
            if (num > 0)                
                pq.offer(num);
            i++;
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            answer += (long) Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}