import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc = 1; tc <= 10; tc++) {
            br.readLine();
            List<String> list = new LinkedList<> (Arrays.asList(br.readLine().split(" ")));
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                String command = st.nextToken();
                switch(command) {
                    case "I":
                        int x1 = Integer.parseInt(st.nextToken());
                        int y1 = Integer.parseInt(st.nextToken());
                        for(int i = 0; i < y1; i++) {
                            String s1 = st.nextToken();
                            list.add(x1 + i, s1);
                        }
                        break;
                    case "D":
                        int x2 = Integer.parseInt(st.nextToken());
                        int y2 = Integer.parseInt(st.nextToken());
                        for(int i = 0; i < y2; i++) {
                            list.remove(x2);
                        }
                        break;
                    default:
                        int y3 = Integer.parseInt(st.nextToken());
                        for(int i = 0; i < y3; i++) {
                            String s3 = st.nextToken();
                            list.add(s3);
                        }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 10; i++) {
                sb.append(" ").append(list.get(i));
            }
            System.out.println(String.format("#%d%s", tc, sb.toString()));
        }
    }
}
