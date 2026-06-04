// 4시간 40분 + A
import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int totalSec = strTimeToSec(play_time);
        int[] viewerPerSec = new int[totalSec + 1];
        long[] prefixViewTime = new long[totalSec + 1];
        int adPlayTime = strTimeToSec(adv_time);
        int maxPlayTimeStartSec = 0;
        long maxPlayTime = 0;
        
        for (String log : logs) {
            String[] viewInfo = log.split("-");
            int start = strTimeToSec(viewInfo[0]);
            int end = strTimeToSec(viewInfo[1]);
            
            viewerPerSec[start]++;
            viewerPerSec[end]--;
        }
        
        // s는 s ~ s+1초까지를 의미함
        for (int s = 1; s <= totalSec; s++) {
            viewerPerSec[s] += viewerPerSec[s - 1];
            prefixViewTime[s] = prefixViewTime[s - 1] + viewerPerSec[s - 1];
            if (s < adPlayTime)
                continue;
            long playTime = prefixViewTime[s] - prefixViewTime[s - adPlayTime];
            if (playTime <= maxPlayTime)
                continue;
            maxPlayTime = playTime;
            maxPlayTimeStartSec = s - adPlayTime;
        }
        
        return secToStrTime(maxPlayTimeStartSec);
    }
    
    private int strTimeToSec(String strTime) {
        String[] timeInfo = strTime.split(":");
        int hToS = Integer.parseInt(timeInfo[0]) * 60 * 60;
        int mToS = Integer.parseInt(timeInfo[1]) * 60;
        int s = Integer.parseInt(timeInfo[2]);
        
        return hToS + mToS + s;
    }
    
    private String secToStrTime(int s) {
        StringBuilder sb = new StringBuilder();
        int h = s / (60 * 60);
        s -= h * (60 * 60);
        int m = s / 60;
        s -= m * 60;
        
        if (h < 10) sb.append('0');
        sb.append(String.valueOf(h));
        sb.append(':');
        if (m < 10) sb.append('0');
        sb.append(String.valueOf(m));
        sb.append(':');
        if (s < 10) sb.append('0');
        sb.append(String.valueOf(s));
        
        return sb.toString();
    }
}