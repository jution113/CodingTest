import java.util.*;

class Solution {
    private int n;
    private int answer;
    private boolean[] colCheck;
    private int[] row;
    
    public int solution(int n) {
        this.n = n;
        answer = 0;
        colCheck = new boolean[n];
        // idx -> col, val -> row
        row = new int[n];
        Arrays.fill(row, -1);
        
        putQueen(0, 0);
        
        return answer;
    }
    
    private void putQueen(int r, int queen) {        
        if (r == n) {
            if (queen == n) answer++;
            return;
        }
        
        for (int nc = 0; nc < n; nc++) {
            // System.out.println(String.format("%d | (%d, %d) | %s | %s", queen, r, nc, !colCheck[nc], validateCross(r, nc)));
            if (colCheck[nc] || !validateCross(r, nc)) continue;
            
            colCheck[nc] = true;
            row[nc] = r;
            putQueen(r + 1, queen + 1);
            colCheck[nc] = false;
            row[nc] = -1;
        }
    }
    
    private boolean validateCross(int r, int c) {
        int cr = c + 1;
        int cl = c - 1;
        
        for (int nr = r - 1; nr >= 0; nr--) {
            if (cr < n && nr == row[cr]) return false;
            if (cl >= 0 && nr == row[cl]) return false;
            cr++;
            cl--;
        }
        
        return true;
    }
}