import java.util.*;
import java.io.*;

class Solution {
    private static final int TOTAL_TEST_CASE = 10;
    private static final int LEN = 100; 
    
    // 입력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    
    // 맵 관련
    private static char[][] map;
    
    private static int maxPalindromeLen;
    
	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();
        
		for(int i = 1; i <= TOTAL_TEST_CASE; i++) {
        	int testCase = Integer.parseInt(br.readLine());
            init();
            findMaxPalindromeLen();
            sb.append("#" + testCase + " " + maxPalindromeLen + "\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        map = new char[LEN][LEN];
        
        for (int r = 0; r < LEN; r++) {
        	String rowInput = br.readLine();
            for (int c = 0; c < LEN; c++) {
                map[r][c] = rowInput.charAt(c);
            }
        }
        
        maxPalindromeLen = 1;
    }
    
    private static void findMaxPalindromeLen() {
        for (int r = 0; r < LEN; r++) {
            for (int c = 0; c < LEN; c++) {
                maxPalindromeLen = Math.max(maxPalindromeLen, Math.max(findPalindromeLenInRow(r, c), findPalindromeLenInCol(r, c)));
                maxPalindromeLen = Math.max(maxPalindromeLen, Math.max(findPalindromeLenInRow(r, c, c + 1), findPalindromeLenInCol(r, r + 1, c)));
            }
        }
    }
    
    private static int findPalindromeLenInRow(int row, int col) {
        int len = 1;
        int right = col + 1;
        int left = col - 1;
        
        while (left >= 0 && right < LEN && map[row][left] == map[row][right]) {
            right++;
            left--;
            len += 2;
        }
        
        return len;
    }
    
    private static int findPalindromeLenInRow(int row, int col, int col2) {
        int len = 0;
        int right = col2;
        int left = col;
        
        while (left >= 0 && right < LEN && map[row][left] == map[row][right]) {
            right++;
            left--;
            len += 2;
        }
        
        return len;
    }
    
    private static int findPalindromeLenInCol(int row, int col) {
        int len = 1;
        int up = row - 1;
        int down = row + 1;
        
        while (up >= 0 && down < LEN && map[up][col] == map[down][col]) {
            down++;
            up--;
            len += 2;
        }
        
        return len;
    }
    
    private static int findPalindromeLenInCol(int row, int row2, int col) {
        int len = 0;
        int up = row;
        int down = row2;
        
        while (up >= 0 && down < LEN && map[up][col] == map[down][col]) {
            down++;
            up--;
            len += 2;
        }
        
        return len;
    }
}