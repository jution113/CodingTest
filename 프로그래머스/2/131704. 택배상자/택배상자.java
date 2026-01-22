import java.util.*;

class Solution {
    public int solution(int[] order) {
        ArrayDeque<Integer> stack = new ArrayDeque<> ();
        int i = 0;
        int answer = 0;
        
        for (int o = 1; o <= order.length; o++) {
            stack.push(o);
            
            while (!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                answer++;
                i++;
            }
            
        }
        return answer;
    }
}