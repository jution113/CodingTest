import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int P;
    static int sum = 0;
    static int[] arr;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        prefixSum = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        prefixSum[0] = arr[0];
        sum = arr[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
            sum += prefixSum[i];
        }
        System.out.println(sum);
    }
}