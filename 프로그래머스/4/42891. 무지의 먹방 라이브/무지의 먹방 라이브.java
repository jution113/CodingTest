import java.util.*;

class Solution {
    public int solution(int[] foodTimes, long endTime) {
        PriorityQueue<int[]> pq = new PriorityQueue<> ((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        
        for (int i = 0; i < foodTimes.length; i++) pq.offer(new int[] {foodTimes[i], i});
        
        long remainTime = endTime;
        int traversalSum = 0;
        
        // 음식을 다 먹거나, 시간을 다 소진할 때까지 동작
        while (!pq.isEmpty()) {
            int[] foodInfo = pq.peek();
            int needTraversal = foodInfo[0] - traversalSum;
            long needTime = (long) needTraversal * pq.size();
            
            if (needTime > remainTime) {
                int maxTraversal = (int) (remainTime / pq.size());
                
                traversalSum += maxTraversal;
                remainTime -= pq.size() * maxTraversal;
                break;
            }
            
            pq.poll();
            traversalSum += needTraversal;
            remainTime -= needTime;
        }
        
        // 음식을 다 먹은 경우
        if (pq.isEmpty()) {
            return -1;
        }
        
        int[] remainFoods = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) remainFoods[i++] = pq.poll()[1];
        Arrays.sort(remainFoods);
        
        return remainFoods[((int) remainTime) % remainFoods.length] + 1;
    }
}