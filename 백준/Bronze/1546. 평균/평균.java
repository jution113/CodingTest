import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        int maxNum = 0;
        for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                nums[i] = num;
                maxNum = Math.max(maxNum, num);
        }
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (double) nums[i] / maxNum * 100;
        }
        System.out.print(sum / N);
    }
}
