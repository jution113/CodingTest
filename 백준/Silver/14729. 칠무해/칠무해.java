import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine()) * 1000;
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 7; i++) {
            sb.append(String.format("%.3f", arr[i] / 1000.0));
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
