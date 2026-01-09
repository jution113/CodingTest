import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> map1 = new HashMap<> ();
        Map<Integer, Integer> map2 = new HashMap<> ();
        int n = topping.length;
        int answer = 0;        
        
        for (int i = 0; i < n; i++) {
            int t = topping[i];
            
            if (i == 0) {
                map1.put(t, 1);                
            } else {
                map2.put(t, map2.getOrDefault(t, 0) + 1);
            }
        }
        
        if (map1.size() == map2.size())
            answer++;
        
        for (int i = 1; i < n; i++) {
            int t = topping[i];
            
            int cnt = map2.get(t);
                
            if (cnt - 1 <= 0) {
                map2.remove(t);
            } else {
                map2.put(t, cnt - 1);
            }
            map1.put(t, map1.getOrDefault(t, 0) + 1);
            
            if (map1.size() == map2.size())
                answer++;
        }
        
        return answer;
    }
}