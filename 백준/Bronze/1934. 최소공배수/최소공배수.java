import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            long num1 = Integer.parseInt(st.nextToken());
            long num2 = Integer.parseInt(st.nextToken());
            
            bw.write(String.valueOf(lcm(num1, num2)) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
    
    static long gcd(long x, long y) {
        if(y == 0) return x;
        return gcd(y, x % y);
    }
    
    static long lcm(long x, long y) {
        return x * y / gcd(x, y);
    }
}