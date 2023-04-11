import java.util.*;
import java.io.*;

public class Main {
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
        
        
        
        if(bubbleSort(arr, k) == -1) {
            bw.write(String.valueOf(-1));
        } else {
            for(int i = 0; i < n; i++) {
                bw.write(String.valueOf(arr[i]) + " ");
            }
        }
        
        bw.flush();
        bw.close();
        
    }
    
    static int bubbleSort(int[] n, int k) {
        int length = n.length;
        int fixedIdx = length - 1;
        int swapCount = 0;
        
        while(fixedIdx > 0) {
            int lastIdx = 0;
            
            for(int i = 0; i < fixedIdx; i++) {
                if(n[i] > n[i+1]) {
                    swap(n, i, i+1);
                    swapCount++;
                    lastIdx = i + 1;
                    if(swapCount == k) break;
                }
            }
            
            fixedIdx = lastIdx;
            if(swapCount == k) break;
        }
        
        if(swapCount < k) {
            return -1;
        } else {
            return 0;
        }
    }
    
    static void swap(int[] n, int x, int y) {
        int stamp = n[x];
        n[x] = n[y];
        n[y] = stamp;
    }
}