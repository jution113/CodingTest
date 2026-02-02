import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int i = 0;
        int j = 0;
        int n = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        while (i < n && j < n) {
            if (B[j] > A[i]) {
                i++;
                j++;
                answer++;
            } else {
                j++;
            }
        }
        
        return answer;
    }
}