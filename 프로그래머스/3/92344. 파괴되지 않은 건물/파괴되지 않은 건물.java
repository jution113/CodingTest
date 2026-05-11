import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int yLen = board.length;
        int xLen = board[0].length;
        int[][] degreeSum = new int[yLen + 1][xLen + 1];
        
        for (int[] info : skill) {
            int degree = info[5];
            degree *= info[0] == 1 ? -1 : 1;
            int y = info[1]; 
            int y2 = info[3];
            int x = info[2]; 
            int x2 = info[4];
            
            degreeSum[y][x] += degree;
            degreeSum[y][x2 + 1] += -1 * degree;
            degreeSum[y2 + 1][x] += -1 * degree;
            degreeSum[y2 + 1][x2 + 1] += degree;
        }
        
        for (int y = 0; y < yLen; y++) {
            
            for (int x = 1; x < xLen; x++) degreeSum[y][x] += degreeSum[y][x - 1];
        }
        
        
        int answer = 0;
        
        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen; y++) {
                if (y > 0) degreeSum[y][x] += degreeSum[y - 1][x];
                board[y][x] += degreeSum[y][x];
                if (board[y][x] > 0) answer++;
            }            
        }
        
        return answer;
    }
}