import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashMap<String, Integer> gemCntMap = new HashMap<> ();
        
        for (String gem : gems) {
            if (!gemCntMap.containsKey(gem))
                gemCntMap.put(gem, 0);
        }
        
        HashSet<String> exsitGemSet = new HashSet<> ();
        int[] answer = new int[2];
        int answerLen = Integer.MAX_VALUE;
        int start = 0;
        
        for (int end = 0; end < gems.length; end++) {
            String gem = gems[end];
            
            gemCntMap.put(gem, gemCntMap.getOrDefault(gem, 0) + 1);
            exsitGemSet.add(gem);
            
            while (exsitGemSet.size() == gemCntMap.size()) {
                String targetGem = gems[start];
                int targetGemCnt = gemCntMap.get(targetGem);
                
                if (targetGemCnt == 1) {
                    exsitGemSet.remove(targetGem);
                    
                    if (end - start < answerLen) {
                        answer[0] = start + 1;
                        answer[1] = end + 1;
                        answerLen = end - start;
                    }
                }
                
                start++;
                gemCntMap.put(targetGem, targetGemCnt - 1);
            }
        }
        
        int gemsLen = gems.length;
        
        while (exsitGemSet.size() == gemCntMap.size()) {
                String targetGem = gems[start];
                int targetGemCnt = gemCntMap.get(targetGem);
                
                if (targetGemCnt == 1) {
                    exsitGemSet.remove(targetGem);
                    
                    if (gemsLen - 1 - start < answerLen) {
                        answer[0] = start + 1;
                        answer[1] = gemsLen;
                        answerLen = gemsLen - 1 - start;
                    }
                }
                
                start++;
                gemCntMap.put(targetGem, targetGemCnt - 1);
            }
        
        return answer;
    }
}