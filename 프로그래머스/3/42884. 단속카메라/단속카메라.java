import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<Time> pq = new PriorityQueue<> ();
        for (int[] route : routes) {
            pq.offer(new Time(route[0], route[1]));
        }
        
        int pos = pq.poll().out;
        int answer = 1;
        
        while (!pq.isEmpty()) {
            Time now = pq.poll();
            
            if (now.in <= pos)
                continue;
            pos = now.out;
            answer++;
        }
        
        return answer;
    }
    
    static class Time implements Comparable<Time> {
        int in;
        int out;
        
        public Time(int in, int out) {
            this.in = in;
            this.out = out;
        }
        
        @Override
        public int compareTo(Time other) {
            if (this.out == other.out)
                return this.in - other.in;
            return this.out - other.out;
        }
    }
}