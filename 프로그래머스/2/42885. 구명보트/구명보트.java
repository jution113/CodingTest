import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int start = 0;
        int end = people.length - 1;
        int boatCnt = 0;
        
        // people 오름차순 정렬
        Arrays.sort(people);
        
        while (start <= end) {
            int cnt = 0;
            int sum = 0;
            
            
            // 가장 무거운 사람부터 먼저 싣기 
            while (cnt < 2 && end >= start && sum + people[end] <= limit) {
                sum += people[end];
                end--;
                cnt++;
            }
            
            // 가벼운 사람을 1명 더 태울 수 있다면, 더 태우기
            if (cnt < 2 && start <= end && sum + people[start] <= limit) {
                sum += people[start];
                start++;
                cnt++;
            }
            
            boatCnt++;
            cnt = 0;
            sum = 0;
        }
        
        return boatCnt;
    }
}