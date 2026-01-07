import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> typeCntMap = new HashMap<> ();
        int answer = 0;
        
        for (String[] clothe : clothes) {
            String name = clothe[0];
            String type = clothe[1];
            int cnt = 1;
            
            if (typeCntMap.containsKey(type))
                cnt = typeCntMap.get(type) + 1;
            typeCntMap.put(type, cnt);
        }
        
        int[] cntArr = typeCntMap.values().stream()
            .mapToInt(Integer::intValue)
            .toArray();
        int n = cntArr.length;
        
        for (int i = 0; i < n; i++) {
            int cnt = cntArr[i];
            
            for (int j = i + 1; j < n; j++) {
                cnt *= cntArr[j] + 1;
            }
            
            answer += cnt;
        }
        
        return answer;
    }
}