import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        selectionSort(arr, k);
        
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
                    System.out.print(arr[maxIdx] + " " + arr[i]);
                    return;
                }
            }
        }
        
        if(swapCount < k) System.out.print(-1);
    }
    
    static void swap(int[] arr, int x, int y) {
        int stamp = arr[x];
        arr[x] = arr[y];
        arr[y] = stamp;
    }
}