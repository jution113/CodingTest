import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);

        int i = 0;
        int j = n - 1;
        int result = 0;

        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == x) {
                result++;
                i++;
                j--;
            } else if(sum > x) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println(result);
    }
}
