import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] nums = new int[N]; 
			for(int n = 0; n < N; n++) nums[n] = Integer.parseInt(st.nextToken());
			
			boolean[] sumCheck = new boolean[10001];
			sumCheck[0] = true;
			int maxSum = 0;
			
			for(int num : nums) {
				maxSum += num;
				
				for(int sum = maxSum; sum >= 0; sum--) {
					if(sumCheck[sum]) sumCheck[sum + num] = true; 
				}
			}
			
			int totalCount = 0;
			for(boolean sum : sumCheck) if(sum) totalCount++;
			
			System.out.println("#" + tc + " " + totalCount);
		}

	}
}
