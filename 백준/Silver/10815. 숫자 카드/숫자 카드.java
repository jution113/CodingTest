import java.io.*;
import java.util.*;

 class Main {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         int N = Integer.parseInt(br.readLine());
         int[] nArr = new int[N];
         st = new StringTokenizer(br.readLine());
         
         for(int i =0; i < N; i++) {
             nArr[i] = Integer.parseInt(st.nextToken());
         }
         
         Arrays.sort(nArr);
         
         int M = Integer.parseInt(br.readLine());
         st = new StringTokenizer(br.readLine());
         
         for(int i = 0; i < M; i++) {
             int num = Integer.parseInt(st.nextToken());
             System.out.print(binarySearch(nArr, num) + " ");
         }
     }
     
     static int binarySearch(int[] arr, int num) {
         int start = 0;
         int end = arr.length - 1;
         
         while(end - start >= 0) {
             int center = (start + end) / 2;
             
             if(arr[center] == num) {
                 return 1;
             } else if(arr[center] < num) {
                 start = center + 1;
             } else {
                 end = center - 1;
             }
         }
         return 0;
     }
 }