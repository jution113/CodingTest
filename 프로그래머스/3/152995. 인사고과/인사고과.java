import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] target = scores[0];
        
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<> ((a, b) -> {
            return b - a;
        });
        pq.offer(scores[0][0] + scores[0][1]);
        
        int max = scores[0][1];
        for (int i = 1; i < scores.length; i++) {
            int[] score = scores[i];
            
            max = Math.max(max, score[1]);
            
            if (score[1] < max) {
                if (score[0] == target[0] && score[1] == target[1]) return -1;
                continue;
            }
            
            pq.offer(score[0] + score[1]);
        }

        int answer = 1;
        while (!pq.isEmpty()) {
            if (target[0] + target[1] == pq.poll()) break;
            answer++;
        }
        
        return answer;
    }
}