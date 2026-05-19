import java.util.*;

class Solution {
    private final int N = 3;
    
    public int solution(String[] board) {
        int oCnt = 0;
        int xCnt = 0;
        
        // intBoard init
        int[][] intBoard = new int[N][N];
        
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (board[y].charAt(x) == 'O') {
                    intBoard[y][x] = 1;
                    oCnt++;
                } else if (board[y].charAt(x) == 'X') {
                    intBoard[y][x] = 2;
                    xCnt++;
                } else {
                    intBoard[y][x] = 0;
                }
            }
        }
        
        boolean isOWin = validateGame(intBoard, 1);
        boolean isXWin = validateGame(intBoard, 2);
        
        // 선공이 후공보다 둔 돌의 수가 적을 경우 -> 게임 룰 위반
        if (oCnt < xCnt) return 0;
        // 선공과 후공의 둔 돌의 수 차이가 1개 초과일 경우 -> 게임 룰 위반
        if (Math.abs(oCnt - xCnt) > 1) return 0;
        // 동시 승리 -> 게임 룰 위반
        if (isOWin && isXWin) return 0;
        // 선공 승리 시, 후공보다 둔 돌 수가 같거나 적다면 -> 게임 를 위반
        if (isOWin && oCnt <= xCnt) return 0;
        // 후공 승리 시, 선공과 둔 돌의 수가 다르다면 -> 게임 를 위반
        if (isXWin && oCnt != xCnt) return 0;
        
        return 1;
    }
    
    private boolean validateGame(int[][] intBoard, int winner) {
        int crossLCnt = 0;
        int crossRCnt = 0;
        
        for (int i = 0; i < N; i++) {
            int rowCnt = 0;
            int colCnt = 0;
            
            for (int j = 0; j < N; j++) {
                if (intBoard[i][j] == winner) rowCnt++;
                if (intBoard[j][i] == winner) colCnt++;
            }
            
            if (intBoard[i][i] == winner) crossLCnt++;
            if (intBoard[i][N - 1 - i] == winner) crossRCnt++;
            
            if (rowCnt == 3 || colCnt == 3 || crossLCnt == 3 || crossRCnt == 3) return true;
        }
        
        return false;
    }
}