import java.util.*;
import java.io.*;

class Solution {
    private static final int COLOR_CNT = 3;
    private static final int WHITE = 0;
    private static final int BLUE = 1;
    private static final int RED = 2;
    
    // 입력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    // 국기 정보
    private static int yLen;
    private static int xLen;
    private static char[][] russiaFlag;
    
    // 칠 정보
    private static int[][] paintInfo;
    private static int minPaint;
    
	public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        int totalTestCase = Integer.parseInt(br.readLine());
        
		for(int testCase = 1; testCase <= totalTestCase; testCase++) {
            init();
            findMinPaintCnt();
            sb.append("#" + testCase + " " + minPaint+ "\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());
        
        russiaFlag = new char[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
             String rowInfo = br.readLine();
            for (int x = 0; x < xLen; x++) {
            	russiaFlag[y][x] = rowInfo.charAt(x);
            }
        }
        
        paintInfo = new int[COLOR_CNT][yLen];
        for (int y = 0; y < yLen; y++) {
            int paintWhite = 0;
            int paintBlue = 0;
            int paintRed = 0;
            
            for (int x = 0; x < xLen; x++) {
                if (russiaFlag[y][x] != 'W') paintWhite++;
                if (russiaFlag[y][x] != 'B') paintBlue++;
                if (russiaFlag[y][x] != 'R') paintRed++;
            }
            
            paintInfo[WHITE][y] = paintWhite;
            paintInfo[BLUE][y] = paintBlue;
            paintInfo[RED][y] = paintRed;
        }
        
        minPaint = Integer.MAX_VALUE;
    }
    
    private static void findMinPaintCnt() {
        for (int whiteHeight = 1; whiteHeight <= yLen - 2; whiteHeight++) {
            for (int blueHeight = 1; blueHeight <= yLen - 1; blueHeight++) {
                minPaint = Math.min(minPaint, getPaint(whiteHeight, blueHeight));
        	}
        }
    }
    
    private static int getPaint(int whiteHeight, int blueHeight) {
        int paint = 0;
        
        for (int y = 0; y < yLen; y++) {
            if (y < whiteHeight) {
                paint += paintInfo[WHITE][y];
            } else if (y < blueHeight) {
                paint += paintInfo[BLUE][y];
            } else {
                paint += paintInfo[RED][y];
            }
        }
        
        return paint;
    }
}