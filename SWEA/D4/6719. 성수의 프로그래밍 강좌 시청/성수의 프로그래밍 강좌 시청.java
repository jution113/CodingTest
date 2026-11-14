import java.util.*;
import java.io.*;

class Solution {
    // 입력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    // 점수 관련
    private static double a;
    private static int n;
    private static int k;
    private static int[] ms;
    
	public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        int totalTestCase = Integer.parseInt(br.readLine());
        
		for(int testCase = 1; testCase <= totalTestCase; testCase++) {
            init();
            maxA();
            sb.append("#" + testCase + " " + a + "\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        ms = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) ms[i] = Integer.parseInt(st.nextToken());

        a = 0;
    }
    
    private static void maxA() {
        Arrays.sort(ms);
        for (int i = n - k; i < n; i++) {
            a = (a + ms[i]) / 2;
        }
    }
}