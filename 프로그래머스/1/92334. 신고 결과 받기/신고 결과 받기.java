import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // <신고자 id, 신고 당한 id Set>
        Map<String, Set<String>> hashMap = new HashMap<> ();
        
        for(String r : report) {
            String id1 = r.split(" ")[0];
            String id2 = r.split(" ")[1];
            
            if(!hashMap.containsKey(id1)) hashMap.put(id1, new HashSet<String> ());
            
            hashMap.get(id1).add(id2); // put을 안해줘도 되나?
        }
        
        // <신고 당한 id : 신고 당한 횟수>
        Map<String, Integer> hashMap2 = new HashMap<> ();
        
        // 신고 당한 id마다 신고 횟수 갱신
        hashMap.entrySet().stream()
            .forEach(entrySet -> { // 신고 당한 id set
                entrySet.getValue().stream()
                    .forEach(id -> { // 신고 당한 id
                        if(!hashMap2.containsKey(id)) hashMap2.put(id, 0);
                        hashMap2.put(id, hashMap2.get(id) + 1);
                    });
            });
        
        // 신고 당한 횟수가 k 이상인 <신고 당한 id> Set
        Set<String> id2Set = hashMap2.entrySet().stream()
            .filter(entrySet -> entrySet.getValue() >= k)
            .map(entrySet -> entrySet.getKey())
            .collect(Collectors.toSet());
        
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) {
            String id1 = id_list[i];
            
            if(!hashMap.containsKey(id1)) continue;
            
            int reportCount = (int) hashMap.get(id1).stream()
                .filter(id2 -> id2Set.contains(id2))
                .count();
            
            answer[i] = reportCount;
        }
        
        
        return answer;
    }
}