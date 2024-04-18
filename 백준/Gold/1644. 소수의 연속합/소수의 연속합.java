import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n + 1];
        int result = 0;

        if(n == 1) {
            System.out.println(0);
            return;
        };

        if(n <= 3) {
            System.out.println(1);
            return;
        }

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;


        for(int i = 2; i * i <= n; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int beforePrimeNum = 2;

        for(int i = 2; i <= n; i ++) {
            if(!isPrime[i]) continue;
            if(i > 2 &&  i + beforePrimeNum > n) break;

            int primeSum = 0;
            int primeNum = i;
            beforePrimeNum = i;

            while(primeSum < n) {
                if(isPrime[primeNum]) primeSum += primeNum;
                primeNum++;
            }

            if(primeSum == n) result++;
        }

        if(isPrime[n]) result++;

        System.out.println(result);

    }
}
