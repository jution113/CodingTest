import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        Map<Integer, String> findByNumMap = new HashMap<> ();
        Map<String, Integer> findByPosMap = new HashMap<> ();
        
        int y = 1;
        int x = 1;
        int num = 1;
        
        while(num <= 1000000) {
            int nextY = y;
            while(nextY > 0) {
                String pos = nextY + " " + x;
                //System.out.println(num + " - " + pos);
                findByNumMap.put(num, pos);
                findByPosMap.put(pos, num);
                num++;
                nextY--;
                x++;
            }
            y++;
            x = 1;
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            String[] pos1 = findByNumMap.get(p).split(" ");
            String[] pos2 = findByNumMap.get(q).split(" ");
            String newPos = (Integer.parseInt(pos1[0]) + Integer.parseInt(pos2[0])) + " " + (Integer.parseInt(pos1[1]) + Integer.parseInt(pos2[1]));
			sb.append(findByPosMap.get(newPos)).append("\n");
        }
        System.out.println(sb.toString());
	}
}