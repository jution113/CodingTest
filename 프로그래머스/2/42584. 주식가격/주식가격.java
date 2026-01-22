import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<> ();
        
        for (int curT = 0; curT < n; curT++) {
            int curP = prices[curT];
            
            while (!stack.isEmpty() && prices[stack.peek()] > curP) {
                int prevT = stack.pop();
                answer[prevT] = curT - prevT;
            }
            stack.push(curT);
        }
        
        while (!stack.isEmpty()) {
            int prevT = stack.pop();
            answer[prevT] = n - 1 - prevT;
        }
        
        return answer;
    }
}