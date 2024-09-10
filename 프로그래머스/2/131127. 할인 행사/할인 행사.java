import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> hashMap = new HashMap<> ();
        int n = want.length;
        int total = 0;
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            hashMap.put(want[i], number[i]);
            total += number[i];
        }
        
        for(int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> hashMapCheck = new HashMap<> (hashMap);
            int totalCheck = total;
            
            for(int j = 0; j < 10; j++) {
                String key = discount[i + j];
                if(hashMapCheck.containsKey(key) && hashMapCheck.get(key) > 0) {
                    hashMapCheck.put(key, hashMapCheck.get(key) - 1);
                    totalCheck -= 1;
                }
            }
            
            if(totalCheck == 0) answer++;
        }
        
        return answer;
    }
}