import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean isAllMinus = true;
        int[] nums = new int[N];
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if(isAllMinus) isAllMinus = nums[i] < 0;
            if(max < nums[i]) max = nums[i];
        }

        if(!isAllMinus) {
            int sum = 0;
            max = Integer.MIN_VALUE;

            for(int i = 0; i < N; i++) {
                int num = nums[i];
                if(sum + num < 0) {
                    sum = 0;
                    continue;
                }
                sum += num;
                if(sum > max) max = sum;
            }
        }

        System.out.println(max);
    }
}
