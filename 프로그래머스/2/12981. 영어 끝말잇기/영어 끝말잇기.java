import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Map<Integer, Integer> appCntMap = new HashMap<> ();
        Set<String> dupWord = new HashSet<> ();
        char lastChar = 'a';
        
        for (int i = 0; i < words.length; i++) {
            int idx = i % n + 1;
            int appCnt = 1;
            String word = words[i];
            
            if (appCntMap.containsKey(idx))
                appCnt = appCntMap.get(idx) + 1;
            
            appCntMap.put(idx, appCnt);
            
            if (dupWord.contains(word) || (i != 0 && lastChar != word.charAt(0))) {
                answer[0] = idx;
                answer[1] = appCnt;
                break;
            }
            
            dupWord.add(word);
            lastChar = word.charAt(word.length() - 1);
        }
        return answer;
    }
}