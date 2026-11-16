import java.util.*;
import java.io.*;

class Solution {
    private static final int WORD_CNT = 5;
    
    // 입출력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    
    // 단어 관련
    private static String[] words;
    private static int maxWordLen;
    
	public static void main(String args[]) throws Exception {
		int testCaseCnt = Integer.parseInt(br.readLine());
        
		for(int testCase = 1; testCase <= testCaseCnt; testCase++) {
            init();
        	sb.append("#" + testCase + " ");
            makeRes();
        	sb.append("\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        words = new String[WORD_CNT];
        maxWordLen = 0;
        for (int i = 0; i < WORD_CNT; i++) {
            words[i] = br.readLine();
        	maxWordLen = Math.max(maxWordLen, words[i].length());
        }
    }
    
    private static void makeRes() {
        for (int i = 0; i < maxWordLen; i++) {
            for (String word : words) {
                if (i + 1 > word.length()) continue;
        		sb.append(word.charAt(i));
            }
        }
    }
}