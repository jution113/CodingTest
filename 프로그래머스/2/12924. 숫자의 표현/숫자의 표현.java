import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 1;
        int start = 1;
        int end = 2;
        int sum = start + end;
        
        if (n < 3)
            return 1;
        
        // n의 절반까지만 반복
        while (start <= n / 2) {
            if (sum == n)
                    answer++;
            if (sum <= n) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }
        
        // 자기 자신의 수인 n을 추가해서 반환
        return answer;
    }
}