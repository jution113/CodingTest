import java.util.*;
import java.io.*;

class Solution {
    // 입출력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    //  단어 관련
    private static String word;
    private static String word2;
    private static int[][] dp;
    
	public static void main(String args[]) throws IOException {
	    int testCaseCnt = Integer.parseInt(br.readLine());

		for(int testCase = 1; testCase <= testCaseCnt; testCase++) {
            init();
            LCS();
			sb.append("#" + testCase + " " + dp[word.length()][word2.length()] + "\n");
		}
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        word = st.nextToken();
        word2 = st.nextToken();
        dp = new int[word.length() + 1][word2.length() + 1];
    }
    
    private static void LCS() {
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                dp[i][j] = word.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
}