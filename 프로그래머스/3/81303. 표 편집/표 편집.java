import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> deletedRows = new Stack<> ();
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];
        
        k++;
        
        for(int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        for(int i = 0; i < cmd.length; i++) {
            if(cmd[i].charAt(0) == 'C') {
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                deletedRows.push(k);
                k = down[k] <= n ? down[k] : up[k];
            } else if(cmd[i].charAt(0) == 'Z') {
                int recoverRow = deletedRows.pop();
                up[down[recoverRow]] = recoverRow;
                down[up[recoverRow]] = recoverRow;
            } else {
                for(int j = 0; j < Integer.valueOf(cmd[i].split(" ")[1]); j++) {
                    k = cmd[i].charAt(0) == 'U' ? up[k] : down[k];
                }
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for(Integer row : deletedRows) {
            answer[row - 1] = 'X';
        }
        
        return new String(answer);
    }
}