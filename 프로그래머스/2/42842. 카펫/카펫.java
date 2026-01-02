class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        int wid = 0;
        
        for (int len = 1; len * len <= yellow; len++) {
            if (yellow % len != 0)
                continue;
            
            wid = yellow / len;
            
            if ((wid + 2) * 2 + len * 2 == brown) {
                answer[0] = wid + 2;
                answer[1] = len + 2;
                break;
            }
        }
        return answer;
    }
}