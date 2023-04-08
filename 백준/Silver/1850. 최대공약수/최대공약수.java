import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long num1 = Long.parseLong(st.nextToken());
        long num2 = Long.parseLong(st.nextToken());
        
        long gcdNum = gcd(Math.max(num1, num2), Math.min(num1, num2));
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < gcdNum; i++) {
            result.append("1");
        }
        
        System.out.print(result);
        //bw.write(result);
        //bw.flush();
        //bw.close();
    }
    
    public static long gcd(long x, long y) {
        if(y == 0) return x;
        return gcd(y, x % y);
    } 
}