import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[] buildings = new int[N];
            String[] input = br.readLine().split(" ");
            int sum = 0;
            
            for(int i = 2; i < N - 2; i++) buildings[i] = Integer.parseInt(input[i]);
            for(int i = 0; i < N; i++) {                
                if(i < 2 || N - 2 <= i) continue;
                
                int cur = buildings[i];
                int left = Integer.max(buildings[i - 2], buildings[i - 1]);
                int right = Integer.max(buildings[i + 1], buildings[i + 2]);
                
                if(left >= cur || cur <= right) continue;
                
                sum += cur - Integer.max(left, right);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}