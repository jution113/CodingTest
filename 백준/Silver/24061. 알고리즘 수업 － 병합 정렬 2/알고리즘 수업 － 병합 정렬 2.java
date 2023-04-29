import java.util.*;
import java.io.*;

public class Main {
    public static int n = 0;
    public static int k = 0;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr);

        if(count < k) {
            bw.write("-1");
        } else {
            for(int i = 0; i < n; i++) {
                bw.write(arr[i] + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            int left = start;
            int right = mid + 1;
            int idx = start;

            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);

            while(left <= mid && right <= end && count < k) {
                tmp[idx++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
                count++;
            }

            while(left <= mid && count < k) {
                tmp[idx++] = arr[left++];
                if(count < k) count++;
            }

            while(right <= end && count < k) {
                tmp[idx++] = arr[right++];
                if(count < k) count++;
            }

            for(int i = start; i <= end; i++) {
                arr[i] = tmp[i];
            }
        }
    }
}