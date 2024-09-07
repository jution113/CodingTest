import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<> ();
        
        for(int progress : progresses) {
            queue.offer(progress);
        }
        
        int bendCount = 1;
        int bendStandard = getNeedDay(progresses[0] , speeds[0]);
        
        ArrayList<Integer> answer = new ArrayList<> ();
        
        for(int i = 1; i < progresses.length; i++) {
            queue.poll();
            int needDay = getNeedDay(progresses[i] , speeds[i]);
            
            if(needDay <= bendStandard) {
                bendCount++;
            } else {
                answer.add(bendCount);
                bendCount = 1;
                bendStandard = needDay;
            }
        }
        
        answer.add(bendCount);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static private int getNeedDay(int progress, int speed) {
        int day = 1;
        int remain = 100 - progress;
        
        if(remain <= speed) return day;
        
        day = remain / speed;
        
        if(remain % speed > 0) day++;
        
        return day;
    }
}