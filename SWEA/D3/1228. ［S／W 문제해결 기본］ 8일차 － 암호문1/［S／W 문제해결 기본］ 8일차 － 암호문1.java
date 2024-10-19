import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= 10; tc++) {
            br.readLine();
            List<String> origin = new LinkedList<> (Arrays.asList(br.readLine().split(" ")));
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                st.nextToken();
                int start = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                for(int i = 0; i < n; i++) origin.add(start + i, st.nextToken());
            }
            sb.append("#").append(tc).append(" ");
            for(int i = 0; i < 10; i++) sb.append(origin.get(i)).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
	}
}