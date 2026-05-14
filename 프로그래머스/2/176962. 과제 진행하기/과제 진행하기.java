import java.util.*;

class Solution {
    private static class Subject {
        int start;
        int playTime;
        String name;
        
        public Subject(int start, int playTime, String name) {
            this.start = start;
            this.playTime = playTime;
            this.name = name;
        }
    }
    
    private static class RemainSubject {
        int remainTime;
        String name;
        
        public RemainSubject(int remainTime, String name) {
            this.remainTime = remainTime;
            this.name = name;
        }
    }
    
    public String[] solution(String[][] plans) {
        // 시작 시간 기준 오름차순 정렬
        PriorityQueue<Subject> pq = new PriorityQueue<> ((o, o2) -> {
            return Integer.compare(o.start, o2.start);
        });
        
        for (String[] plan : plans) {
            int start = timeToMin(plan[1]);
            int playTime = Integer.parseInt(plan[2]);
            String name = plan[0];
            pq.offer(new Subject(start, playTime, name));
        }
        
        ArrayDeque<RemainSubject> stack = new ArrayDeque<> ();
        String[] answer = new String[plans.length];
        int i = 0;
        
        while (!pq.isEmpty()) {
            Subject sub = pq.poll();
            int start = sub.start;
            int playTime = sub.playTime;
            int end = start + playTime;
            int nextStart = !pq.isEmpty() ? pq.peek().start : Integer.MAX_VALUE;
            
            if (end <= nextStart) {
                answer[i++] = sub.name;
                
                if (end == nextStart) continue;
                
                while (!stack.isEmpty()) {
                    end += stack.peek().remainTime;
                    
                    if (end <= nextStart) {
                        answer[i++] = stack.pop().name;
                    } else {
                        stack.peek().remainTime = end - nextStart;
                        break;
                    }
                }
            } else {
                stack.push(new RemainSubject(end - nextStart, sub.name));
            }
        }
        
        return answer;
    }
    
    private int timeToMin(String time) {
        String[] strArr = time.split(":");
        return Integer.parseInt(strArr[0]) * 60 + Integer.parseInt(strArr[1]);
    }
}