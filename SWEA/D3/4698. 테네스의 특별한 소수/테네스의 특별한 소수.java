import java.util.*;
import java.io.*;

class Solution {
    private static final int MAX_END = 1_000_000;
    
    // 입출력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    // 소수 계산 관련
    private static int digit;
    private static int start;
    private static int end;
    private static int primeCountWithDigit;
    private static boolean[] isPrime = new boolean[MAX_END + 1];
    
	public static void main(String args[]) throws IOException {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int num = 2; num * num <= MAX_END; num++) {
            int mutiplier = num;
            while (num * mutiplier <= MAX_END) isPrime[num * mutiplier++] = false;
        }
        
        int testCaseCount = Integer.parseInt(br.readLine());
        
		for(int testCase = 1; testCase <= testCaseCount; testCase++) {
            init();
            findPrimeCountWithDigit();
            sb.append("#" + testCase + " " +  primeCountWithDigit + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        digit = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        primeCountWithDigit = 0;
    }
    
    private static void findPrimeCountWithDigit() {
        for (int num = start; num <= end; num++) {
            if (isPrime[num] && containsDigit(num, digit)) primeCountWithDigit++;
        }
    }
    
    private static boolean containsDigit(int num, int digit) {
        String strNum = String.valueOf(num);
        return strNum.contains(String.valueOf(digit));
    }
}