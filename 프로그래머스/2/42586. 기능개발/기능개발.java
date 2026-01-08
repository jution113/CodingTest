import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<> ();
        int i = 0;
        int day = 1;
        int curDeployCnt = 0;
        int preDeployCnt = 0;
        
        while (i < progresses.length) {
            if (progresses[i] + day * speeds[i] >= 100) {
                curDeployCnt++;
                i++;
            } else {
                day++;
                curDeployCnt = 0;
                if (curDeployCnt != preDeployCnt) {
                    answer.add(preDeployCnt);
                }
            }
            preDeployCnt = curDeployCnt;
        }
        answer.add(curDeployCnt);
        
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}