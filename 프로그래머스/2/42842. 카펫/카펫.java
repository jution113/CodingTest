class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        int len = 1;
        
        for (int wid = yellow; wid > 0; wid--) {
            if (yellow % wid != 0)
                continue;
            
            len = yellow / wid;
            
            if ((wid + 2) * 2 + len * 2 == brown) {
                answer[0] = wid + 2;
                answer[1] = len + 2;
                break;
            }
        }
        return answer;
    }
}