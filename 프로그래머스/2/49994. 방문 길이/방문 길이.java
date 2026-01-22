import java.util.*;

class Solution {
    static int[] dirY = {1, 0, -1, 0};
    static int[] dirX = {0, 1, 0, -1};
    static int[][] map = new int[5][5];
    
    public int solution(String dirs) {
        Set<String> pathRecord = new HashSet<> ();
        int y = 0;
        int x = 0;
        int answer = 0;
        
        for (char dir : dirs.toCharArray()) {
            int i;

            switch(dir) {
                case 'U':
                    i = 0;
                    break;
                case 'R':
                    i = 1;
                    break;
                case 'D':
                    i = 2;
                    break;
                default:
                    i = 3;
            }
            
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];
            
            if (nextY < -5)
                nextY = -5;
            if (nextY > 5)
                nextY = 5;
            if (nextX < -5)
                nextX = -5;
            if (nextX > 5)
                nextX = 5;
            
            StringBuilder keyFowardPart = new StringBuilder();
            keyFowardPart.append(y);
            keyFowardPart.append(x);
            
            StringBuilder keyBackPart = new StringBuilder();
            keyBackPart.append(nextY);
            keyBackPart.append(nextX);
            
            if (keyFowardPart.toString().equals(keyBackPart.toString())) {
                continue;
            }
            
            String key1 = keyFowardPart.toString() + keyBackPart.toString();
            String key2 = keyBackPart.toString() + keyFowardPart.toString();
            
            if (!pathRecord.contains(key1) && !pathRecord.contains(key2))
                answer++;
            pathRecord.add(key1);
            pathRecord.add(key2);
            
            x = nextX;
            y = nextY;   
        }
        
        return answer;
    }
}