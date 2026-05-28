import java.util.*;

class Solution {
    private final int MAX_SCORE = 10;
    private int[] info;
    private int[] answer;
    private int maxScoreDiff;
    
    public int[] solution(int n, int[] info) {
        this.info = info;
        answer = new int[info.length];
        maxScoreDiff = 0;
        
        int socreA = 0;
        for (int i = 0; i < info.length; i++)
            if (info[i] > 0) socreA += MAX_SCORE - i;
        
        comb(0, n, new int[info.length], socreA, 0);
        
        for (int k : answer)
            if (k != 0) return answer;
        
        return new int[] {-1};
    }
    
    private void comb(int start, int remain, int[] shoot, int scoreA, int scoreB) {
        if (remain == 0) {
            boolean isUpdate = false;
            int scoreDiff = scoreB - scoreA;
            
            if (scoreDiff == 0) return;
            if (maxScoreDiff < scoreDiff) {
                maxScoreDiff = scoreDiff;
                isUpdate = true;
            } else if (maxScoreDiff == scoreDiff) {
                for (int i = info.length - 1; i >= 0; i--) {
                    if (shoot[i] == answer[i]) continue;
                    if (shoot[i] > answer[i]) isUpdate = true;
                    break;
                }
            }
            
            if (isUpdate) answer = Arrays.copyOf(shoot, info.length);
            return;
        }
        
        for (int i = start; i < info.length; i++) {
            int score = MAX_SCORE - i;
            int need = info[i] + 1;
            int nextScoreA = info[i] > 0 ? scoreA - score : scoreA;
            int nextScoreB = scoreB + score;
            
            if (i == info.length - 1) {
                shoot[i] = remain;
                comb(i + 1, 0, shoot, nextScoreA, nextScoreB);
                shoot[i] = 0;
                return;
            }
            
            if (need > remain) continue;
                
            shoot[i] = need;
            comb(i + 1, remain - need, shoot, nextScoreA, nextScoreB);
            shoot[i] = 0;
        }
    }
}