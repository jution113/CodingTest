import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Boolean> map = new HashMap<> ();
        
        for (String phone : phone_book) {
            int n = phone.length();
            
            for (int i = 0; i < n; i++) {
                String prefix = phone.substring(0, i + 1);
                boolean isEnd = i == (n - 1);
                
                if (map.containsKey(prefix) && (map.get(prefix) || isEnd))
                    return false;
                
                map.put(prefix, isEnd);
            }
        }        
        
        return true;
    }
}