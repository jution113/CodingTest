import java.util.*;

class Solution {
    public int solution(int bridgeLength, int limitWeight, int[] truckWeights) {
        Queue<Integer> que = new LinkedList<> ();
        int n = truckWeights.length;
        int[] posArr = new int[n];
        int totalWeight = 0;
        int time = 0;
        int i = 0;
        
        que.offer(i);
        totalWeight += truckWeights[i];
        i++;
        time++;
        
         while (!que.isEmpty()) {
             time++;
             que.offer(-1);
             
             while (!que.isEmpty()) {
                 int pos = que.poll();
                 if (pos == -1)
                     break;
                 posArr[pos]++;
                 if (posArr[pos] < bridgeLength) {
                     que.offer(pos);
                 } else {
                     totalWeight -= truckWeights[pos];
                 }
            }
            
            if (i < truckWeights.length && totalWeight + truckWeights[i] <= limitWeight) {
                que.offer(i);
                totalWeight += truckWeights[i];
                i++;
            }
        }
        
        return time;
    }
}