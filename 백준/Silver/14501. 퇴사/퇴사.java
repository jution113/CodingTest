import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] day = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int targetDay = i + T - 1;
            int expectedPay = i == 0 ? P : day[i - 1] + P;
            if (targetDay < N && expectedPay > day[targetDay])
                    day[targetDay] = expectedPay;

            if (i > 0 && day[i - 1] > day[i])
                day[i] = day[i - 1];
        }
        
        System.out.println(day[N - 1]);
    }
}
