import java.util.*;

class Solution {
    static int answer;
    static Set<Integer> isChecked;
    
    public int solution(String numbers) {
        answer = 0;
        isChecked = new HashSet<> ();
        int n = numbers.length();
        
        permutation(numbers, n, new StringBuilder(), new boolean[n]);
        
        return answer;
    }
    
    private void permutation(String numbers, int n, StringBuilder sb, boolean[] isUsed) {
        for (int i = 0; i < n; i++) {
            if (isUsed[i])
                continue;
            
            isUsed[i] = true;
            sb.append(numbers.charAt(i));
            
            int num = Integer.parseInt(sb.toString());                
            if (isPrime(num) && !isChecked.contains(num)) {
                isChecked.add(num);
                answer++;
            }
            permutation(numbers, n, sb, isUsed);
            
            sb.deleteCharAt(sb.length() - 1);
            isUsed[i] = false;
        }
    }
    
    private boolean isPrime(int num) {
        if (num <= 1)
            return false;
        
        int i = 2;
        
        while (i <= Math.sqrt(num)) {
            if (num % i == 0)
                return false;
            i++;
        }
        
        return true;
    }
}