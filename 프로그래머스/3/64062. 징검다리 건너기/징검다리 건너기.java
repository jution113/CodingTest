class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean canCross(int[] stones, int k, int friends) {
        int skipCnt = 0;
        
        for (int stone : stones) {
            if (friends > stone) {
                skipCnt++;
                if (skipCnt == k) {
                    return false;
                }
            } else {
                skipCnt = 0;
            }
        }
        
        return true;
    }
}