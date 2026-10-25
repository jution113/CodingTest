import java.util.*;
import java.io.*;

class Solution {
    private static final int ALPHABET_CNT = 26;
    private static final int LOWERCASE_START_IDX = 97;
    
    private static int N;
    private static char[] A;
    private static char[] B;
    private static char[] C;
    
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
		for(int t= 1;  t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            A = br.readLine().toCharArray();
            B = br.readLine().toCharArray();
            C = br.readLine().toCharArray();
            
            char[] commonWord = makeCommonWord();
            int answer = getModificationCnt(commonWord);
            sb.append("#" + t + " " + answer + "\n");
		}
        System.out.println(sb.toString());
	}
    
    private static char[] makeCommonWord() {
        char[] commonWord = new char[N];
        
        for (int i = 0; i < N; i++) {
        	int[] appearCnt = new int[ALPHABET_CNT];

            appearCnt[charToIdx(A[i])]++;
            appearCnt[charToIdx(B[i])]++;
            appearCnt[charToIdx(C[i])]++;
            
            commonWord[i] = findMaxAppearChar(appearCnt);
        }
        
        return commonWord;
    }
    
    private static int charToIdx(char c) {
        return ((int) c) - LOWERCASE_START_IDX;
    }
    
    private static char findMaxAppearChar(int[] appearCnt) {
        int maxAppearCnt = 0;
        char c = 'a';
        
        for (int i = 0; i < ALPHABET_CNT; i++) {
            if (appearCnt[i] > maxAppearCnt) {
				maxAppearCnt = appearCnt[i];
                c  = (char) (i + LOWERCASE_START_IDX);
            }
        }
        
        return c;
    }
    
    private static int getModificationCnt(char[] commonWord) {
        int modificationCnt = 0;
        
        for (int i = 0; i < N; i++) {
            if (A[i] != commonWord[i]) modificationCnt++;
            if (B[i] != commonWord[i]) modificationCnt++;
            if (C[i] != commonWord[i]) modificationCnt++;
        }
        
        return modificationCnt;
    }
    
}