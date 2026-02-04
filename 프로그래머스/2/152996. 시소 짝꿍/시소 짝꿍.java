import java.util.*;

class Solution {
    public long solution(int[] weights) {
        HashMap<Integer, Long> map = new HashMap<> ();
        
        for (int weight : weights)
            map.put(weight, map.getOrDefault(weight, 0L) + 1);
            
        long answer = 0;
        for (Map.Entry entrySet : map.entrySet()) {
            int weight = (int) entrySet.getKey();
            long cnt = (long) entrySet.getValue();
            
            if (cnt > 1)
                answer += (cnt * (cnt - 1)) / 2;
            
            int targetWeight = weight * 2;
            if (targetWeight % 3 == 0) {
                targetWeight /= 3;
                answer += cnt * map.getOrDefault(targetWeight, 0L);
            }
            
            targetWeight = weight * 2;
            if (targetWeight % 4 == 0) {
                targetWeight /= 4;
                answer += cnt * map.getOrDefault(targetWeight, 0L);
            }
            
            targetWeight = weight * 3;
            if (targetWeight % 4 == 0) {
                targetWeight /= 4;
                answer += cnt * map.getOrDefault(targetWeight, 0L);
            }
        }
        
        return answer;
    }
}