import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int firstPrime = 0;
        int primeSum = 0;
        boolean isFindFirstPrime = false;
        
        for(int i = N; i <= M; i++) {
            if(i == 1) continue;
            
            boolean isPrime = true;
            
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime) {
                if(!isFindFirstPrime) {
                    firstPrime = i;
                    isFindFirstPrime = true;
                }
                primeSum += i;
            }
        }
        
        if(firstPrime == 0) {
            System.out.println(-1);
        } else {
            System.out.println(primeSum);
            System.out.println(firstPrime);
        }
        
    }
}