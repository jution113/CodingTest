import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        for(int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(num == 1) continue;
            
            boolean isPrime = true;
            for(int j = 2; j <= Math.sqrt(num); j++) {
                if(num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            result += isPrime ? 1 : 0;
            
        }
        
        System.out.println(result);
    }
}