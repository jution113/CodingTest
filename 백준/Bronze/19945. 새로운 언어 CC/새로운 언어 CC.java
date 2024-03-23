import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;

        if(n >= 2) {
            while(n / 2 >= 2) {
                n /= 2;
                cnt++;
            }
            
            cnt++;
        } else if(n < 0) {
            cnt = 32;
        }

        System.out.print(cnt);
    }
}
