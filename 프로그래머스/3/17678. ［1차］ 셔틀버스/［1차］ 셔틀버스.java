import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<> ();
        for (String time : timetable) {
            String[] timeArr = time.split(":");
            pq.offer(Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]));
        }
        
        int totalCnt = 0;
        int cnt = 0;
        int next = 9 * 60;
        int last = next;
        
        for (int i = 0; i < n; i++) {
            cnt = 0;
            last = next;
            
            while (!pq.isEmpty() && pq.peek() <= next && cnt < m) {
                last = pq.poll();
                cnt++;
            }
            
            totalCnt += cnt;
            next += t;
        }
        
        next -= t;
        
        // 여유로워서 출발 시각에 맞춰 탔는지, 다른사람보다 1분 먼저 탔는지 구분할 것        
        if (cnt < m) {
            last = next;
        } else {
            last--;
        }
        
        String hour = String.valueOf(last / 60);
        if (last / 60 < 10) hour = "0" + hour;
        String min = String.valueOf(last % 60);
        if (last % 60 < 10) min = "0" + min;
        return hour + ":" + min;
    }
}