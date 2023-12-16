import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            int result = 0;

            for(int j = 5; j <= input; j *= 5) {
                result += input / j;
            }

            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}
