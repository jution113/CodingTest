import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> cache = new ArrayList<> ();
        int answer = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            int i = cache.indexOf(city);            
            
            if (i < 0) {
                cache.add(city);
                answer += 5;
            } else {
                cache.remove(i);
                cache.add(city);
                answer += 1;
            }
            
            if (cache.size() > cacheSize)
                cache.remove(0);
        }
        
        return answer;
    }
}