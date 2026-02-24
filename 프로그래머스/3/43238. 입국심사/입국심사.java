class Solution {
    public long solution(int n, int[] times) {        
        long answer = 100000000000000L;
        
        long left = 0;
        long right = 100000000000000L;
        
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