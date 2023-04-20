import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        int size = input.length();
        int[] arr = new int[size];
        
        for(int i = 0; i < size; i++) {
            arr[i] = Character.getNumericValue(input.charAt(i));
        }
        
        quickSort(arr, 0, size - 1);
        
        for(int i : arr) {
            bw.write(String.valueOf(i));
        }
        
        bw.flush();
        bw.close();
    }
    
    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = arr[(left + right) / 2];
        
        do {
            while(arr[pl] > pivot) pl++;
            while(arr[pr] < pivot) pr--;
            if(pl <= pr) swap(arr, pl++, pr--);
        } while(pl <= pr);
        
        if(left < pr) quickSort(arr, left, pr);
        if(right > pl) quickSort(arr, pl, right);
    }
    
    static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}