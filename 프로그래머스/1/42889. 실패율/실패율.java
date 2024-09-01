import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        int playerCnt = stages.length;
        Map<Integer, Double> fails = new HashMap<> ();
        
        for(int stageNumber = 1; stageNumber <= N; stageNumber++) {
            int curStageNumber = stageNumber;
            long curStagePlayerCnt = Arrays.stream(stages).filter(e -> e == curStageNumber).count();
            
            if(curStagePlayerCnt == 0) {
                fails.put(stageNumber, 0.0);
            } else {
                fails.put(stageNumber, (double) curStagePlayerCnt / (double) playerCnt);   
                playerCnt -= curStagePlayerCnt;                
            }
        }
        
        return fails.entrySet().stream()
            .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(o -> o.getKey())
            .toArray();
    }
}