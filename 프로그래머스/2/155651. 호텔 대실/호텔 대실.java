import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Time> pq = new PriorityQueue<> ();
        for (String[] time : book_time) {
            String[] inArr = time[0].split(":");
            String[] outArr = time[1].split(":");
            int in = Integer.parseInt(inArr[0]) * 60 + Integer.parseInt(inArr[1]);
            int out = Integer.parseInt(outArr[0]) * 60 + Integer.parseInt(outArr[1]);
            pq.offer(new Time(in, out));
        }
        
        ArrayList<Integer> enterableTimes = new ArrayList<> ();
        while (!pq.isEmpty()) {
            Time time = pq.poll();
            boolean isAdd = false;
            
            for (int i = 0; i <  enterableTimes.size(); i++) {
                if (time.in >= enterableTimes.get(i)) {
                    enterableTimes.set(i, time.out + 10);
                    isAdd = true;
                    break;
                }
            }
            
            if (!isAdd) {
                enterableTimes.add(time.out + 10);
            }
            
            enterableTimes.sort((a, b) -> a - b);
            
        }
        
        return enterableTimes.size();
    }
    
    static class Time implements Comparable<Time>{
        int in;
        int out;
        
        public Time(int in, int out) {
            this.in = in;
            this.out = out;
        }
        
        @Override
        public int compareTo(Time other) {
            if (this.in == other.in)
                return this.out - other.out;
            return this.in - other.in;
        }
    }
}