import java.util.*;
import java.io.*;

// 시나리오
// 이긴시간: 점수가 더 높을 떄 비긴 때는 이긴 시간으로 치지 않는다.
// 이긴시간 = 비긴시간 or 졌을 때 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        
        int gameEndTime = 48 * 60;
        int[] winingTotalTimes = new int[3];
        int[] winingStartTimes = new int[3];
        int[] score = new int[3];

        int winingTeamNumber = 0;
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int teamNumber = Integer.parseInt(st.nextToken());

            String[] goalTimeInfo = st.nextToken().split(":");
            int minute = Integer.parseInt(goalTimeInfo[0]);
            int second = Integer.parseInt(goalTimeInfo[1]);
            int goalTime = (minute * 60) + second;

            score[teamNumber]++;

            if(score[1] > score[2]) {
                if(winingTeamNumber != 1) winingStartTimes[1] = goalTime;
                winingTeamNumber = 1;

                if(i == n - 1) winingTotalTimes[1] += gameEndTime - winingStartTimes[1];

            } else if(score[1] < score[2]) {
                if(winingTeamNumber != 2) winingStartTimes[2] = goalTime;
                winingTeamNumber = 2;

                if(i == n - 1) winingTotalTimes[2] += gameEndTime - winingStartTimes[2];

            } else {
                winingTotalTimes[winingTeamNumber] += goalTime - winingStartTimes[winingTeamNumber];
                winingTeamNumber = 0;

            }
        }

        for(int i = 1; i <= 2; i++) {
            int minute = winingTotalTimes[i] / 60;
            int second = winingTotalTimes[i] % 60;

            if(minute / 10 < 1) sb.append('0');
            sb.append(minute).append(':');
            if(second / 10 < 1) sb.append('0');
            sb.append(second).append('\n');
        }

        System.out.println(sb);

    }
}