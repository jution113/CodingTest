import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayDeque<Task> que = new ArrayDeque<> ();
        int[] sortedpriorities = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(sortedpriorities);
        reverseArray(sortedpriorities);
        int curPriorityPtr = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            que.offer(new Task(i, priorities[i]));
        }
        
        while (!que.isEmpty()) {
            Task task = que.poll();
            
            if (task.priority == sortedpriorities[curPriorityPtr]) {
                curPriorityPtr++;
                if (task.id == location)
                    return curPriorityPtr;
            } else {
                que.offer(task);
            }
        }
        
        return -1;
    }
    
    private void reverseArray(int[] array) {
        int n = array.length;
        
        for (int i = 0; i < n / 2; i++) {
            int tmp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = tmp;
        }
    }
    
    private class Task {
        int id;
        int priority;
        
        public Task(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}