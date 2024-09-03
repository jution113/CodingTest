import java.util.*;

class Solution {
    static Stack<Integer> bucket = new Stack<> ();
    static int n = 0;
    static int answer = 0;
    
    public int solution(int[][] board, int[] moves) {
        
        n = board.length;
        
        int[] depths = depthCheck(board);
        
        for(int i = 0; i < moves.length; i++) {
            int xPos = moves[i] - 1;
            int yPos = depths[xPos];
            if(yPos == -1) continue;
            
            int target = board[yPos][xPos];
            
            bucketCheck(target);
            board[yPos][xPos] = 0;
            depths[xPos]++;
            if(depths[xPos] >= n) depths[xPos] = -1;
        }
        
        return answer;
    }
    
    static int[] depthCheck(int[][] board) {
        int[] depths = new int[n];
        Arrays.fill(depths, -1);
        
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                if(depths[x] == -1 && board[y][x] != 0) depths[x] = y;
            }
        }
        
        return depths;
    }
    
    static void bucketCheck(int e) {
        if(bucket.isEmpty()) {
            bucket.push(e);
        } else {
            if(e == bucket.peek()) {
                bucket.pop();
                answer += 2;
            } else {
                bucket.push(e);
            }
        }
    }
}