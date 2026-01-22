import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Deque<Integer> stack = new ArrayDeque<> ();
        
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            while (!stack.isEmpty() && num > numbers[stack.peek()]) {
                answer[stack.pop()] = num;
            }
            stack.push(i);
        }
        
        return answer;
    }
}