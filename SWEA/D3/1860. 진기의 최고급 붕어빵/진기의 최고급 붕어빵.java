import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        testCase:
        for(int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            List<Integer> visitedTimeList = new ArrayList<> ();
            
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) visitedTimeList.add(Integer.parseInt(st.nextToken()));
            visitedTimeList.sort(Comparator.reverseOrder());
            int firstVisitedTime = visitedTimeList.get(visitedTimeList.size() - 1);
            int lastVisitedTime = visitedTimeList.get(0);
            
            if(firstVisitedTime == 0) {
                sb.append("Impossible").append("\n");
                continue;
            }
            
            int[] visitedTimeWithrProductCount = new int[lastVisitedTime + 1];
            
            for(int time = 1; time <= lastVisitedTime; time++ ) {
                visitedTimeWithrProductCount[time] = visitedTimeWithrProductCount[time - 1];
                if(time % M == 0) visitedTimeWithrProductCount[time] += K;
                
                if(time == visitedTimeList.get(visitedTimeList.size() - 1)) {
                    if(visitedTimeWithrProductCount[time] < 1) {
                        sb.append("Impossible").append("\n");
                        continue testCase;
                    }
                    visitedTimeWithrProductCount[time] -= 1;
                    visitedTimeList.remove(visitedTimeList.size() - 1);
                }
            }
            
            sb.append("Possible").append("\n");
        }
        System.out.println(sb.toString());
	}
}