import java.io.*;

public class Main {
    static int n;
    static int[] arr = new int[1001];

    public static void main(String[] args) throws IOException {
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= 1000; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(arr[Integer.parseInt(br.readLine())]);
    }
}
