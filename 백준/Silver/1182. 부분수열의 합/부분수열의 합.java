import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> list;
    static int N;
    static int S;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<> ();
        while(st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));

        for(int i = 1; i <= N; i++) {
            makeCombination(0, 0, i, 0);
        }

        System.out.println(result);
    }

    static void makeCombination(int start, int curDepth, int maxDepth, int sum) {
        if(curDepth == maxDepth) {
            if(sum == S) result++;
            return;
        }

        for(int i = start; i < N; i++) {
            makeCombination(i + 1, curDepth + 1, maxDepth, sum + list.get(i));
        }
    }
}
