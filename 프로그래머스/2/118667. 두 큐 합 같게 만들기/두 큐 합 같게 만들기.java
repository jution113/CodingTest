import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        ArrayDeque<Integer> q1 = new ArrayDeque<> ();
        ArrayDeque<Integer> q2 = new ArrayDeque<> ();
        
        int q1Max = 0;
        int q2Max = 0;
        long q1Sum = 0;
        long q2Sum = 0;
        long sum = 0;
        for (int i = 0; i < queue1.length; i++) {
            int v1 = queue1[i];
            int v2 = queue2[i];
            
            q1.offer(v1);
            q2.offer(v2);
            
            q1Max = Math.max(q1Max, v1);
            q2Max = Math.max(q2Max, v2);
            
            q1Sum += v1;
            q2Sum += v2;
            sum += v1 + v2;
        }
        
        if ((sum & 1) == 1)
            return -1;
        
        long target = sum / 2;
        
        if (q1Max > target || q2Max > target)
            return -1;
        
        int answer = 0;
        while (answer < queue1.length * 4) {
            if (q1Sum == q2Sum)
                return answer;
            
            if (q1Sum < q2Sum) {
                int v = q2.pop();
                q1.offer(v);
                q2Sum -= v;
                q1Sum += v;
            } else {
                int v = q1.pop();
                q2.offer(v);
                q1Sum -= v;
                q2Sum += v;
            }
            answer++;
        }
        
        return -1;
    }
}