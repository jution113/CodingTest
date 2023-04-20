import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        quickSort(arr, 0, n - 1);
        
        for(int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    
    static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = arr[(left + right) / 2];

        do{
            while(arr[pl] < pivot) pl++;
            while(arr[pr] > pivot) pr--;
            if(pl <= pr) swap(arr, pl++, pr--); // 증감 연산을 안해주면 무한 루프에 빠짐
        } while(pl <= pr);

        if(left < pr) quickSort(arr, left, pr);
        if(pl < right) quickSort(arr, pl, right);
    }
}