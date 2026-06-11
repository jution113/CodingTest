import java.util.*;

class Solution {
    private HashMap<Long, Long> nextByCur;
    private long[] answer;
    
    public long[] solution(long k, long[] roomNumber) {
        nextByCur = new HashMap<> ();
        answer = new long[roomNumber.length];
        
        for (int i = 0; i < roomNumber.length; i++)
            answer[i] = dfs(roomNumber[i]) - 1;
        
        return answer;
    }
    
    private long dfs(long num) {
        long next = num + 1;
        
        if (nextByCur.containsKey(num))
            next = dfs(nextByCur.get(num));
        
        nextByCur.put(num, next);
        return next;
    }
}