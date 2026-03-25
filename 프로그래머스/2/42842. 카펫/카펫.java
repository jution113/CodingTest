import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int y = 1;
        int x = yellow / y;
        
        while (brown != (x + 2) * 2 + (y * 2)) {
            y++;
            if (yellow % y == 0)
                x = yellow / y;
        }
        
        int[] answer = {x + 2, y + 2};
        return answer;
    }
}