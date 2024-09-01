import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        
        Set<String> hashSet = new HashSet<> ();
        
        for(int i = 0; i < dirs.length(); i++) {
            int nextX = x;
            int nextY = y;
            
            switch(dirs.charAt(i)) {
                case('U'):
                    nextY++;
                    break;
                case('D'):
                    nextY--;
                    break;
                case('R'):
                    nextX++;
                    break;
                default:
                    nextX--;
            }
            
            if(nextX < -5 || 5 < nextX || nextY < -5 || 5 < nextY) continue;
            
            String startPos = String.valueOf(x) + String.valueOf(y);
            String endPos = String.valueOf(nextX) + String.valueOf(nextY);
            
            hashSet.add(startPos + endPos);
            hashSet.add(endPos + startPos);
            
            x = nextX;
            y = nextY;
        }
        
        return hashSet.size() / 2;
    }
    
    
}