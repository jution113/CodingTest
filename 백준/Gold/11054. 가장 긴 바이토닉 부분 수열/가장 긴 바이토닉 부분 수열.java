import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] maxLenMemo = new int[n];
        Arrays.fill(maxLenMemo, 1);
        int[] maxLenMemo2 = new int[n];
        Arrays.fill(maxLenMemo2, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) maxLenMemo[i] = Math.max(maxLenMemo[i], maxLenMemo[j] + 1);
                if (arr[n - 1 - j] < arr[n - 1 - i]) maxLenMemo2[n - 1 - i] = Math.max(maxLenMemo2[n - 1 - i], maxLenMemo2[n - 1 - j] + 1);
            }
        }
        
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLenMemo[i] + maxLenMemo2[i] - 1, maxLen);
        }
        
        System.out.println(maxLen);
    }
}