import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        
        System.out.println(power(a, b, c));
    }
    
    private static long power(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        
        long half = power(a, b / 2, c);
        
        if ((b & 1) == 0) {
            return (half * half) % c;
        } else {
            return (((half * half) % c) * (a % c)) % c;
        }
    }
}