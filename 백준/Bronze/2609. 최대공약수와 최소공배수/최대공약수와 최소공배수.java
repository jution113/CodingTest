import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        
        int gcd = num1 > num2 ? gcd(num1, num2) : gcd(num2, num1);
        int lcm = num1 * num2 / gcd;
        
        bw.write(String.valueOf(gcd) + "\n");
        bw.write(String.valueOf(lcm));
        bw.flush();
        bw.close();
    }
    
    static int gcd(int x, int y) {
        if(y == 0) return x;
        return gcd(y, x % y);
    }
}