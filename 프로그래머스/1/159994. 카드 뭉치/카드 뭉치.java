import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cards1Que = new ArrayDeque<> ();
        Queue<String> cards2Que = new ArrayDeque<> ();
        
        for(String card : cards1) cards1Que.offer(card);
        for(String card : cards2) cards2Que.offer(card);
        
        for(String word : goal) {
            if(!cards1Que.isEmpty() && cards1Que.peek().equals(word)) {
                cards1Que.poll();
                continue;
            }
            
            if(!cards2Que.isEmpty() && cards2Que.peek().equals(word)) {
                cards2Que.poll();
                continue;
            }
            
            return "No";
        }
                
        return "Yes";
    }
}