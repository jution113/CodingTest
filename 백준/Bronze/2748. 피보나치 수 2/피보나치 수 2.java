import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] fibonacciArr = new long[91];
        fibonacciArr[1] = 1;
        for(int i = 2; i <= N; i++) {
            fibonacciArr[i] = fibonacciArr[i - 1] + fibonacciArr[i - 2];
        }
        System.out.println(fibonacciArr[N]);
    }
}
