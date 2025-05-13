import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr = new int[12];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i <= 11; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            sb.append(arr[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb);
    }
}
