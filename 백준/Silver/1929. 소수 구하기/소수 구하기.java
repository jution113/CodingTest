import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        for(int i = M; i <= N; i++) {
            if(i == 1) continue;
            boolean isPrime = true;
            
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime) System.out.println(i);
        }
        
    }
}