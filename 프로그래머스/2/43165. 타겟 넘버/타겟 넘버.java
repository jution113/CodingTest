import java.util.*;

class Solution {
    static int cnt;
    static int tar;
    static int[] nums;
    
    public int solution(int[] numbers, int target) {
        cnt = 0;
        tar = target;
        nums = numbers;
        
        bfs();
        
        return cnt;
    }
    
    private void bfs() {
        Queue<Step> que = new ArrayDeque<> ();
        que.offer(new Step(0, nums[0]));
        que.offer(new Step(0, nums[0] * -1));
        
        while (!que.isEmpty()) {
            Step s = que.poll();
            
            int nextIdx = s.idx + 1;
            int nextValue1 = s.value + nums[nextIdx];
            int nextValue2 = s.value + nums[nextIdx] * -1;
            
            if (nextIdx == nums.length - 1) {
                if (nextValue1 == tar)
                    cnt++;
                if (nextValue2 == tar)
                    cnt++;
                continue;
            }
            
            que.offer(new Step(nextIdx, nextValue1));
            que.offer(new Step(nextIdx, nextValue2));            
        }
    }
    
    static class Step {
        int value;
        int idx;
        
        public Step(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    } 
}