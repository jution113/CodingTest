import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
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
        
        if(insertionSrot(arr, k) == 0) {
            for(int num : arr) {
                sb.append(num + " ");
            }
        } else {
            sb.append(-1);
        }
        
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
    
    static int insertionSrot(int[] arr, int k) {
        int size = arr.length;
        int exchangeCount = 0;
        
        for(int i = 1; i < size; i++) {
            int target = arr[i];
            int j = i - 1;
            boolean isPassed = arr[j] > target;
            
            while(j >= 0 && arr[j] > target) {
                arr[j + 1] = arr[j];
                j--;
                if(++exchangeCount == k) return 0;
            }
            
            arr[j + 1] = target;
            if(isPassed) {
                if(++exchangeCount == k) return 0;
            }
        }
        
        return exchangeCount < k ? -1 : 0;
    }
}