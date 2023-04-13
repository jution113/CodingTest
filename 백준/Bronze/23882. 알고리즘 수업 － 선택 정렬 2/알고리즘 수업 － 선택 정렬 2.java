import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean isSuccess = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        selectionSort(arr, k);

        if(isSuccess) {
            for(int i = 0; i < n; i++) {
                sb.append(arr[i] + " ");
            }
        } else {
            sb.append(-1);
        }
        // bw.write(String.valueOf(sb));
        // bw.flush();
        // bw.close();

        System.out.print(sb);

    }

    static void selectionSort(int[] arr, int k) {
        int swapCount = 0;

        for(int i = arr.length - 1; i > 0 ; i--) {
            int maxIdx = i;
            boolean isChanged = false;

            for(int j = i; j >= 0; j--) {
                if(arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                    isChanged = true;
                }
            }

            if(isChanged) {
                swap(arr, i, maxIdx);
                swapCount++;

                if(swapCount == k) {
                    return;
                }
            }
        }

        if(swapCount < k) isSuccess = false;
    }

    static void swap(int[] arr, int x, int y) {
        int stamp = arr[x];
        arr[x] = arr[y];
        arr[y] = stamp;
    }
}