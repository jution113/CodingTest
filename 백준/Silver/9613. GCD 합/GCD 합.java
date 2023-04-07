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
            
            int n = Integer.parseInt(st.nextToken());
            int[] nums = new int[n];
            for(int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(nums);
            long sum = 0;
            
            for(int j = 0; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    sum += gcd(nums[j], nums[k]);
                }
            }
            
            bw.write(String.valueOf(sum) + "\n");
            
        }
        
        bw.flush();
        bw.close();
    }
    
    static int gcd(int x, int y) {
        if(y == 0) return x;
        return gcd(y, x % y);
    }
}