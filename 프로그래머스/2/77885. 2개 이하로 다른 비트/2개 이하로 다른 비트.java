class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        
        for (int i = 0; i < len; i++) {
            long number = numbers[i];
            
            if ((number & 1) == 0) {
                answer[i] = number + 1;
                continue;
            }
            
            char[] cArr = ("0" + Long.toBinaryString(number)).toCharArray();
            
            for (int j = cArr.length - 1; j >= 0; j--) {
                if (cArr[j] == '0') {
                    cArr[j] = '1';
                    cArr[j + 1] = '0';
                    break;
                }
            }
            
            answer[i] = toLong(new String(cArr));
        }
        
        return answer;
    }
    
    private long toLong(String str) {
        long sum = 0;
        long base = 2;
        int len = str.length();
        
        if (str.charAt(len - 1) == '1')
            sum += 1;
        
        for (int i = 1; i < len; i++) {
            sum += base * (str.charAt(len - 1 - i) - '0');
            base *= 2;
        }
        
        return sum;
    }
}