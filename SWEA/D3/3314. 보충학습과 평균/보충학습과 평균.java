import java.util.*;
import java.io.*;

class Solution {
    private static final int STUDENT_COUNT = 5;
	private static final int CUT_OFF_SCORE = 40;
    
    // 입출력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    // 점수 관련
    private static int[] scores;
    private static int avgScore;
    
	public static void main(String args[]) throws Exception {
        int testCaseCount = Integer.parseInt(br.readLine());

		for(int testCase = 1; testCase <= testCaseCount; testCase++) {
            init();
            findAvgScore();
            sb.append("#" + testCase + " " + avgScore + "\n");
		}
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        scores = new int[STUDENT_COUNT];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < STUDENT_COUNT; i++) {
            int score = Integer.parseInt(st.nextToken());
            scores[i] = score < CUT_OFF_SCORE  ? CUT_OFF_SCORE : score;
        }
        
        avgScore = 0;
    }
    
    private static void findAvgScore() {
        int scoreSum = 0;
        
        for (int score : scores) scoreSum+= score;
            
        avgScore = scoreSum / STUDENT_COUNT;
    }
}