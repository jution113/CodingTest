import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> lines = new ArrayList<> ();
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] newLine = new int[2];
            newLine[0] = Integer.parseInt(st.nextToken());
            newLine[1] = Integer.parseInt(st.nextToken());
            lines.add(newLine);
        }

        Collections.sort(lines, new Comparator<int[]> () {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] > o2[1] ? 1 : -1;
                }
                return o1[0] > o2[0] ? 1 : -1;
            }
        });

        long totalLength = 0;

        int start = lines.get(0)[0];
        int end = lines.get(0)[1];

        for(int i = 1; i < N; i++) {
            int curStart = lines.get(i)[0];
            int curEnd = lines.get(i)[1];

            if(end < curStart) {
                totalLength += end - start;
                start = curStart;
            }

            end = curEnd > end ? curEnd : end;
        }

        totalLength += end - start;

        System.out.println(totalLength);
    }
}
