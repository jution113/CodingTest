import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int K;
    static int start = 0;
    static int sum = 0;
    static int maxSum = Integer.MIN_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (i < K - 1) {
                sum += arr[i];
            } else if (i == K - 1) {
                sum += arr[i];
                maxSum = Math.max(sum, maxSum);
            } else {
                sum += arr[i] - arr[start++];
                maxSum = Math.max(sum, maxSum);
            }
        }

        System.out.print(maxSum);
    }
}
