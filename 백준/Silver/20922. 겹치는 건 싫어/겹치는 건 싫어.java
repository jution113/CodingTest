import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] numArr = new int[200000];
    static int[] appearedCnt = new int[100001];
    static int len = 0;
    static int maxLen = 0;
    static int startIdx = 0;
    static int endIdx = 0;
    static int endNum;
    static int startNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        while (endIdx < N) {
            endNum = numArr[endIdx];
            startNum = numArr[startIdx];

            if (appearedCnt[endNum] < K) {
                appearedCnt[endNum]++;
                endIdx++;
                len++;
            } else {
                maxLen = Math.max(len, maxLen);
                appearedCnt[startNum]--;
                startIdx++;
                len--;
            }
        }
        maxLen = Math.max(len, maxLen);
        System.out.println(maxLen);
    }
}
