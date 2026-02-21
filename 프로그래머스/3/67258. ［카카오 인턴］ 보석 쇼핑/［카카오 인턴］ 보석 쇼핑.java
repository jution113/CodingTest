import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int minLen = Integer.MAX_VALUE;
        
        HashSet<String> uniqueGemSet = new HashSet<> ();
        for (String gem : gems) {
            uniqueGemSet.add(gem);
        }
        
        HashMap<String, Integer> cntByGem = new HashMap<> ();
        int start = 0;
        for (int end = 0; end < gems.length; end++) {
            cntByGem.put(gems[end], cntByGem.getOrDefault(gems[end], 0) + 1);
            
            if (uniqueGemSet.size() == cntByGem.size()) {
                while (start <= end) {
                    cntByGem.put(gems[start], cntByGem.get(gems[start]) - 1);
                    
                    if (cntByGem.get(gems[start]) == 0) {
                        cntByGem.remove(gems[start]);
                        if (end - start < minLen) {
                            minLen = end - start;
                            answer[0] = start + 1;
                            answer[1] = end + 1;
                        }
                        start++;
                        break;
                    }
                    start++;
                }
            }
        }
        
        return answer;
    }
}