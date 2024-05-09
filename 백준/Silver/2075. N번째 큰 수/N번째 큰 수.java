import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> numArr = new ArrayList<> ();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                numArr.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(numArr, Collections.reverseOrder());

        System.out.println(numArr.get(N - 1));
    }
}
