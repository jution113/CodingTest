import java.io.*;
import java.util.*;

public class Main {
    static String[] src;
    static int totalSum = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sign = str.charAt(0) == '-' ? -1 : 1;
        src = str.split("\\-");
        for (int i = 0; i < src.length; i++) {
            String[] nums = src[i].split("\\+");
            int sum = 0;
            for (String num : nums) sum += Integer.parseInt(num);
            if (i == 0) {
                totalSum += sign * sum;
            } else {
                totalSum += -1 * sum;
            }
        }
        System.out.println(totalSum);
    }
}