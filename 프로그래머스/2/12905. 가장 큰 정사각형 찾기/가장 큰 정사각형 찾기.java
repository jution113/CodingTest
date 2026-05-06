import java.util.*;

class Solution {
    public int solution(int [][]board) {
        int yLen = board.length;
        int xLen = board[0].length;
        
        int[][] vMemo = new int[yLen + 1][xLen + 1];
        int[][] hMemo = new int[yLen + 1][xLen + 1];
        int[][] cMemo = new int[yLen + 1][xLen + 1];
        int[][] sumMemo = new int[yLen + 1][xLen + 1];
        
        for (int y = 1; y <= yLen; y++) {
            for (int x = 1; x <= xLen; x++) {
                if (board[y - 1][x - 1] == 0) continue;
                vMemo[y][x] = vMemo[y][x - 1] + 1;
                hMemo[y][x] = hMemo[y - 1][x] + 1;
                cMemo[y][x] = cMemo[y - 1][x - 1] + 1;
                sumMemo[y][x] = board[y - 1][x - 1] + sumMemo[y - 1][x] + sumMemo[y][x - 1] - sumMemo[y - 1][x - 1];
            }
        }
        
        int answer = 0;
        
        for (int y = 1; y <= yLen; y++) {
            for (int x = 1; x <= xLen; x++) {
                int len = Math.min(cMemo[y][x], Math.min(vMemo[y][x], hMemo[y][x]));
                if (len * len == sumMemo[y][x] - (sumMemo[y - len][x] + sumMemo[y][x - len] - sumMemo[y - len][x - len])) answer = Math.max(answer, len);
            }
        }
        
        return answer * answer;
    }
}