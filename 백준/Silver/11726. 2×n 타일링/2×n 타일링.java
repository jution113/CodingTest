import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 1;
        if(N >= 2) dp[2] = 2;
        for(int i  = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }
        System.out.println(dp[N]);
    }
}

// 1: | -> 1 - q:0, m:1
// 2: ||, = -> 2 - q:1, m:0
// 3: |||, |=, =| -> 3 - q:1, m1
// 4: ||||, ||=, |=|, =||, == -> 5 - q:2, m:0
// 5: |||||, |||=, ||=|, |=||, =|||, |==, =|=, ==| -> 8 - q:2, m:1
// 6: ||||||, ||||=, |||=|, ||=||, |=|||, =||||, ||==, |=|=, |==|, =||=, =|=|, ==||, === -> 13 - q:3, m:0

// dp[i] = dp[i - 2] + dp[i - 1]