import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] memo = new int[N];
        Arrays.fill(memo, 1);
        int[] reverseMemo = new int[N];
        Arrays.fill(reverseMemo, 1);
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        
        int res = memo[N - 1] + reverseMemo[N - 1] - 1;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    reverseMemo[i] = Math.max(reverseMemo[i], reverseMemo[j] + 1);
                }
            }
            res = Math.max(res, memo[i] + reverseMemo[i] - 1);
        }
        
        System.out.println(res);
    }
}