import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());;
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetings, new Comparator<Meeting> () {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                if(m1.endTime == m2.endTime) {
                    return m1.startTime > m2.startTime ? 1 : -1;
                }
                return m1.endTime > m2.endTime ? 1 : -1;
            }
        });

        int meetingCnt = 1;
        int lastEndTime = meetings[0].endTime;

        for(int i = 1; i < N; i++) {
            if(lastEndTime > meetings[i].startTime) continue;
            lastEndTime = meetings[i].endTime;
            meetingCnt += 1;
        }


        System.out.println(meetingCnt);
    }

    static class Meeting {
        int startTime = 0;
        int endTime = 0;
        int usingTime = 0;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            usingTime = endTime - startTime;
        }
    }
}
