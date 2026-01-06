import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < n; i++) {
            int citation = citations[n - i - 1];
            int citationCnt = i + 1;
            
            if (citation >= citationCnt) {
                answer = citationCnt;
            } else {
                break;
            }
        }
        
        return answer;
    }
}