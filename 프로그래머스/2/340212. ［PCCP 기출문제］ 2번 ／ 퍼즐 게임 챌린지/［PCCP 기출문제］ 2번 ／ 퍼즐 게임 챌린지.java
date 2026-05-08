class Solution {
    private int[] diffs;
    private int[] times;
    private long limit;
    private int answer;
    
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        answer = 0;
        
        int maxDiff = 0;
        for (int diff : diffs) maxDiff = Math.max(maxDiff, diff);
        
        binarySearch(1, maxDiff);
        
        return answer;
    }
    
    private void binarySearch(int left, int right) {
        if (left > right) return;

        int mid = (left + right) / 2;
        long sum = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            
            if (diff <= mid) {
                sum += times[i];
            } else {
                sum += (diff - mid) * (times[i - 1] + times[i]) + times[i];
            }
            
            if (sum > limit) break;
        }
        
        if (sum > limit) {
                binarySearch(mid + 1, right);
        } else if (sum < limit) {
            answer = mid;
            binarySearch(left, mid - 1);
        } else {
            answer = mid;
        }
    }
}