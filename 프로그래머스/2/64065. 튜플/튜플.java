import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<> ();
        int i = 1;
        int n = 0;
        
        while (i < s.length() - 1) {
            char c = s.charAt(i);
            
            if (c == '}' || c == ',') {
                map.put(n, map.getOrDefault(n, 0) + 1);
                n = 0;
                if (c == '}')
                    i += 2;
            } else if(c >= '0' && c <= '9') {
                n *= 10;
                n += c - '0';
            }
            
            i++;
        }
        
        int[] answer = new int[map.size()];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            answer[map.size() - entry.getValue()] = entry.getKey();
        }
        return answer;
    }
}