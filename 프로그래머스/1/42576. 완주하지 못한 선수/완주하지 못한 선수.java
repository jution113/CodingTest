import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hashMap = new HashMap<> ();
        
        for(String n : participant) {
            if(hashMap.containsKey(n)){
                hashMap.put(n, hashMap.get(n) + 1);
            } else {
                hashMap.put(n, 1);
            }
        }
        
        for(String n : completion) {
            if(hashMap.containsKey(n)) {
                if(hashMap.get(n) > 1) {
                    hashMap.put(n, hashMap.get(n) - 1);
                } else {
                    hashMap.remove(n);
                }
            }
        }
        
        Set<String> keySet = hashMap.keySet();
        return keySet.stream().findFirst().orElse(null);
    }
}