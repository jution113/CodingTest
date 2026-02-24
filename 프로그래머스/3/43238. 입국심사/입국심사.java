import java.util.*;

class Solution {
    public long solution(int n, int[] times) {        
        long answer = 0;
        
        long left = 0;
        Arrays.sort(times);
        long right = (long) n * (long) times[times.length - 1];
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (validateTime(mid, n, times)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private boolean validateTime(long target, int n, int[] times) {
        long sum = 0;
        
        for (int time : times) {
            sum += target / (long) time;
        }
        
        return n <= sum;
    } 
}