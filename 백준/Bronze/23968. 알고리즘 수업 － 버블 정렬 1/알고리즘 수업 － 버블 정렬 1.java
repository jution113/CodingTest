import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] result = bubbleSort(arr, K);
        
        if(result.length == 0) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(result[0]) + " ");
            bw.write(String.valueOf(result[1]));
        }
        
        bw.flush();
        bw.close();
    }
    
    static int[] bubbleSort(int[] n, int targetExchangeCount) {
        int fixedIndex = n.length - 1;
        int exchangeCount = 0;
        int[] result = new int[2];
        
        while(fixedIndex > 0) {
            int lastChangedIndex = 0;
            
            for(int i = 0; i < fixedIndex; i++) {
                if(n[i] > n[i + 1]) {
                    swap(n, i, i + 1);
                    lastChangedIndex = i + 1;
                    
                    exchangeCount++;
                    if(exchangeCount == targetExchangeCount) {
                        result[0] = n[i];
                        result[1] = n[i + 1];
                        fixedIndex = 0;
                        break;
                    }
                    
                }
                
            }
            
            fixedIndex = lastChangedIndex;
        }
        
        if(exchangeCount < targetExchangeCount) {
            return new int[0];
        } else {
            return result;
        }
    }
    
    static void swap(int[] n, int x, int y) {
        int stamp = n[y];
        n[y] = n[x];
        n[x] = stamp;
    }
}