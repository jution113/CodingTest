import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<> ();
        
        for(int i = 0; i < prices.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int i = stack.pop();
            answer[i] = prices.length - 1 - i;
        }
        
        return answer;
    }
}