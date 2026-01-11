import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> que = new ArrayDeque<> ();
        int n = priorities.length;
        
        for (int i = 0; i < priorities.length; i++) {
            que.offer(new Process(i, priorities[i]));
            
        }
        
        int[] sortedPriorities = priorities;
        Arrays.sort(sortedPriorities);
        
        int i = 1;
        int answer = 0;
        
        while (!que.isEmpty()) {
            Process p = que.poll();
            
            if (p.priority == sortedPriorities[n - i]) {
                answer++;
                
                if (p.id == location)
                    break;
                
                i++;
            } else {
                que.offer(p);
            }
        }
        
        return answer;
    }
    
    static class Process {
        int id;
        int priority;
        
        public Process (int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}