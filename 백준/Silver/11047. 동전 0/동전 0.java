import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int res = 0;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        for (int i = N - 1; i >= 0; i--) {
            if (K == 0) break;
            if (K < arr[i]) continue;
            res += K / arr[i];
            K %= arr[i];
        }
        System.out.println(res);
    }
}