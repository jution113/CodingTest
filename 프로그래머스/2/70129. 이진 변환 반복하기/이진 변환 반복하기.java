import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        int changedSLen = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '1')
                changedSLen++;
        }
        
        answer[0] = 1;
        answer[1] = s.length() - changedSLen;
        
        // s가 1이 아니라면(s의 길이 1은, 곧 값 1을 의미함)
        while (changedSLen > 1) {
            int totalLen = 0;
            int oneCnt = 0;

            // 변환된 s의 길이를 2진법으로 변환 시, 문자열 '1'의 갯수만 계산
            while (changedSLen > 1) {
                if (changedSLen % 2 == 1)
                    oneCnt++;
                changedSLen /= 2;
                totalLen++;
            }
            if (changedSLen == 1)
                    oneCnt++;
            totalLen++;
            
            answer[0]++;
            answer[1] += totalLen - oneCnt;
            changedSLen = oneCnt;
        }
        
        return answer;
    }
}