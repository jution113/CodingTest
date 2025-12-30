class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int n = s.length();
        boolean isInWord = false;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (isDigit(c)) {
                isInWord = true;
            } else if (isLowercase(c)) {
                if (!isInWord)
                    c -= 32;
                isInWord = true;
            } else if (isUpercase(c)) {
                if (isInWord)
                    c += 32;
                isInWord = true;
            } else {
                isInWord = false;
            }
            answer.append(c);
        }
        return answer.toString();
    }
    
    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    
    static boolean isUpercase(char c) {
        return c >= 'A' && c <= 'Z';
    }
    
    static boolean isLowercase(char c) {
        return c >= 'a' && c <= 'z';
    }
}