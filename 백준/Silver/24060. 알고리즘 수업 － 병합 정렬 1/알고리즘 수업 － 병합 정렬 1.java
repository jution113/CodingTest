import java.util.*;
import java.io.*;

public class Main {
    public static int saveCount = 0;
    public static int k = 0;
    public static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void mergeSort(int[] src) {
        int[] tmp = new int[src.length];
        mergeSort(src, tmp, 0, src.length - 1);
    }

    public static void mergeSort(int[] src, int[] tmp, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            int left = start;
            int right = mid + 1;
            int idx = start;

            mergeSort(src, tmp, start, mid);
            mergeSort(src, tmp, mid + 1, end);


            while(left <= mid && right <= end) {
                tmp[idx++] = src[left] < src[right] ? src[left++] : src[right++];
                if(++saveCount == k) {
                    result = tmp[idx - 1];
                    return;
                }
            }

            while(left <= mid) {
                tmp[idx++] = src[left++];
                if(++saveCount == k) {
                    result = tmp[idx - 1];
                    return;
                }
            }

            while(right <= end) {
                tmp[idx++] = src[right++];
                if(++saveCount == k) {
                    result = tmp[idx - 1];
                    return;
                }
            }

            for(int i = start; i <= end; i++) {
                src[i] = tmp[i];
            }
        }
    }
}