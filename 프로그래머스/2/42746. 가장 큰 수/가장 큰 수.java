import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<> ((s1, s2) -> {
            return (s2 + s1).compareTo(s1 + s2);
        });
        
        for (int number : numbers) {
            pq.offer(String.valueOf(number));
        }
        
        StringBuilder answer = new StringBuilder();
        while (!pq.isEmpty()) {
            answer.append(pq.poll());
        }
        
        if (answer.toString().replaceAll("0", "").length() == 0) return "0";
        
        return answer.toString();
    }
    
    
}