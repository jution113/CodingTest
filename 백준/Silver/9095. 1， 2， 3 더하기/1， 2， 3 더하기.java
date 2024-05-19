import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] numArr = new int[T];
        int maxNum = 0;
        for(int i = 0; i< T; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
            if(maxNum < numArr[i]) maxNum = numArr[i];
        }
        dp = new int[maxNum + 1];

        go(1, maxNum);
        go(2, maxNum);
        go(3, maxNum);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T - 1; i++) {
            sb.append(dp[numArr[i]] + "\n");
        }
        sb.append(dp[numArr[T - 1]]);

        System.out.println(sb);
    }
    static void go(int curNum, int targetNum) {
        if(curNum > targetNum) return;
        dp[curNum]++;
        go(curNum + 1, targetNum);
        go(curNum + 2, targetNum);
        go(curNum + 3, targetNum);
    }
}