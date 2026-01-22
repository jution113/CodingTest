import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<> ();
        Map<String, Integer> map2 = new HashMap<> ();
        Set<String> set = new HashSet<> ();
        
        fillMap(str1, map1, set);
        fillMap(str2, map2, set);
        
        if (set.isEmpty())
            return 65536;
        
        double minSum = 0;
        double maxSum = 0;
        for (String key : set) {
            int v1 = map1.getOrDefault(key, 0);
            int v2 = map2.getOrDefault(key, 0);
            minSum += Math.min(v1, v2);
            maxSum += Math.max(v1, v2);
        }
        
        int answer = (int) (minSum / maxSum * 65536);
        return answer;
    }
    
    private void fillMap(String str, Map<String, Integer> map, Set<String> set) {
        str = str.toLowerCase();
        
        for (int i = 0; i < str.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            
            if (!isChar(c1) || !isChar(c2))
                continue;
            
            sb.append(c1);
            sb.append(c2);
            
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            set.add(key);
        }
    }
    
    private boolean isChar(char c) {
        return (c >= 'a') && (c <= 'z');
    }
}