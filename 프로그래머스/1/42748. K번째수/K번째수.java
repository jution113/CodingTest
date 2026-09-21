import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int c = 0; c < commands.length; c++) {
            int[] command = commands[c];
            int i = command[0] - 1;
            int j = command[1] - 1;
            int k = command[2] - 1;
            int[] slicedArray = new int[j - i + 1];
            
            for (int idx = 0; idx <= j - i; idx++) {
                slicedArray[idx] = array[i + idx];
            }
            
            Arrays.sort(slicedArray);
            
            answer[c] = slicedArray[k];
        }
        
        return answer;
    }
}