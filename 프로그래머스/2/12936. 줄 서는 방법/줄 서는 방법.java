import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        long[] factorial = new long[n + 1];
        
        factorial[0] = 1L;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (long) (factorial[i - 1] * i);
        }
        
        LinkedList<Integer> nums = new LinkedList<> ();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        int[] answer = new int[n];
        int j = n - 1;
        k -= 1;
        
        for (int i = 0; i < n; i++) {
            int target = (int) (k / factorial[j]);
            answer[i] = nums.get(target);
            nums.remove(target);
            
            k %= factorial[j--];
        }
        
        return answer;
    }
}