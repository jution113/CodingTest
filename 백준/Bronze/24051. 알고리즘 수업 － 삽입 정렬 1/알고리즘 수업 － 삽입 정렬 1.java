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

        bw.write(String.valueOf(insertion_sort(arr, k)));
        bw.flush();
        bw.close();
    }

    static int insertion_sort(int[] arr, int k) {
        int size = arr.length;
        int exchangeCount = 0;
        
        for(int i = 1; i < size; i++) {
            int j = i - 1; // j는 현재 index보다 1작은 수(즉 비교하려는 수)
            int target = arr[i];
            boolean isPassed = arr[j] < target;
            
            while(j >= 0 && arr[j] > target) {
                if(++exchangeCount == k) return arr[j]; 
                arr[j + 1] = arr[j];
                j--;
            }
            
            // 삽입하려는 위치에 target을 삽입, 여기서 교환이 일어났는지 확인해줘야 한다.
            if(!isPassed) {
                if(++exchangeCount == k) return target;
            }
            arr[j + 1] = target;
        }
        
        if(exchangeCount < k) return -1;
        return 0;
    }
}
