import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            for(int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int count = 0;
            
            for(int i = 0; i < n; i++) {
                List<Integer> line = new ArrayList<> ();
                for(int j = 0; j < n; j++) if(map[j][i] > 0) line.add(map[j][i]);
                while(!line.isEmpty() && line.get(0) == 2) line.remove(0);
                while(!line.isEmpty() && line.get(line.size() - 1) == 1) line.remove(line.size() - 1);
               
                int prev = 1;
                for(int j = 1; j < line.size(); j++) {
                    int cur = line.get(j);
                    if(prev == 1 && cur == 2) count++;
                    prev = cur;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
	}
}