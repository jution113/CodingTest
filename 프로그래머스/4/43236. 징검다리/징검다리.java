import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int answer = 0;
        int left = 0;
        int right = distance;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int removedRockCnt = isValid(distance, mid, rocks);
            
            if (removedRockCnt > n) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private int isValid(int distance, int target, int[] rocks) {
        int removedRockCnt = 0;
        int prevPos = 0;
        
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - prevPos < target) {
                removedRockCnt++;
            } else {
                prevPos = rocks[i];
            }
        }
        
        if (distance - prevPos < target) {
            removedRockCnt++;
        }
        
        return removedRockCnt;
    }
}