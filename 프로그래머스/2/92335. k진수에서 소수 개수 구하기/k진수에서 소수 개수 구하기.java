class Solution {
    public int solution(int n, int k) {
        long sum = 0;
        int mod = 0;
        long digit = 1;
        int answer = 0;
        
        while (n > k) {
            mod = n % k;
            
            if (mod == 0) {
                if (isPrime(sum))
                    answer++;
                sum = 0;
                digit = 1;
            } else {
                sum += mod * digit;
                digit *= 10;
            }
            n /= k;
        }
        sum += n * digit;
        if (isPrime(sum))
            answer++;
        
        return answer;
    }
    
    private boolean isPrime(long sum) {
        if (sum <= 1)
            return false;
        
        if (sum <= 3)
            return true;
        
        int i = 2;
        
        while (i <= Math.sqrt(sum)) {
            if (sum % i == 0)
                return false;
            i++;
        }
        return true;
    }
}