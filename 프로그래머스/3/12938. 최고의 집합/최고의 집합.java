class Solution {
    public int[] solution(int n, int s) {
        int[] answer;

        if (s < n) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (i < n - (s % n)) {
                answer[i] = s / n;
            } else {
                answer[i] = (s / n) + 1;
            }
        }
        
        return answer;
    }
}