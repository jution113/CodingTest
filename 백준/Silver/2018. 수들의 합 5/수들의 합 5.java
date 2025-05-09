import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int sum = 0;
    static int start = 1;
    static int end = 1;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (end <= N) {
            if (end + sum <= N) {
                sum += end;
                if (sum == N) cnt++;
                end++;
            } else {
                sum -= start;
                start++;
            }
        }
        System.out.print(cnt);
    }
}
