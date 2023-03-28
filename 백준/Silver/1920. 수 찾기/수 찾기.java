import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] NArr = new int[N];
        
        for(int i = 0; i < N; i++) {
            NArr[i] = sc.nextInt();
        }
        
        Arrays.sort(NArr);
        
        int M = sc.nextInt();
        
        for(int i = 0; i < M; i++) {
            int num = sc.nextInt();
            System.out.println(binarySearch(NArr, num));
        }
        
    }
    
    static int binarySearch(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
    
        while(start <= end) {
            int center = (start + end) / 2;
            
            if(num > arr[center]) {
                start = center + 1;
            } else if(num < arr[center]) {
                end = center - 1;
            } else {
                return 1;
            }
        }
        
        return 0;
    }
    
}