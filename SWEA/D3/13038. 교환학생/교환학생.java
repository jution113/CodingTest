import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= TC; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] classPlan = new int[7];
            List<Integer> classStartDays = new ArrayList<Integer> ();
            for(int i = 0; i < 7; i++) {
                classPlan[i] = Integer.parseInt(st.nextToken());
                if(classPlan[i] == 1) classStartDays.add(i);
            }
            
            int min = Integer.MAX_VALUE;
            
            for(int classStartDay : classStartDays) {
                int totalDay = 0;
                int classDay = 0;
                
                while(classDay < n) {
					if(classPlan[(classStartDay + totalDay) % 7] == 1) classDay++;
                    totalDay++;
                }
                
                min = Math.min(totalDay, min);
            }
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
	}
}