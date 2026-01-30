import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> tm = new TreeMap<> ();
        
        for (String operation : operations) {
            int len = operation.length();
            
            if (operation.charAt(0) == 'I') {
                int key = Integer.parseInt(operation.substring(2, len));
                tm.put(key, tm.getOrDefault(key, 0) + 1);
            } else if (tm.size() > 0) {
                int key = operation.charAt(2) == '-' ? tm.firstKey() : tm.lastKey() ;
                
                if (tm.get(key) - 1 == 0)
                    tm.remove(key);
                else
                    tm.put(key, tm.get(key) - 1);
            }
        }
        
        int[] answer = new int[2];
        if (tm.size() > 0) {
            answer[0] = tm.lastKey();
            answer[1] = tm.firstKey();
        }
        return answer;
    }
}