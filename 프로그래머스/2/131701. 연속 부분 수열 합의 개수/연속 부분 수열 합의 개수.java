import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<> ();
        
        // 연속된 수열의 길이, i
        for (int i = 0; i < elements.length; i++) {
            
            // 합하기 시작할 원소의 idx, j
            for (int j = 0; j < elements.length; j++) {
                sumSet.add(getSum(i, j, elements));
            }
        }
        
        return sumSet.size();
    }
    
    private int getSum(int depth, int start, int[] elements) {
        int sum = 0;
        
        for (int i = 0; i < depth; i++) {
            sum += elements[(start + i) % elements.length];    
        }
        
        return sum;
    }
}