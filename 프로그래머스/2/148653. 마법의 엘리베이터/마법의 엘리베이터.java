class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey >= 10) {
            int n = storey % 10;
            
            storey /= 10;
            if (n > 5) {
                answer += 10 - n;
                storey++;
            } else if (n == 5) {
                if (storey % 10 >= 5) {
                    storey++;
                }
                answer += n;
                
            } else {
                answer += n;
            }
        }
        
        if (storey > 5) {
            answer += 10 - storey + 1;
        } else {
            answer += storey;
        }
        
        return answer;
    }
}