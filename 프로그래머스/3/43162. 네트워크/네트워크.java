import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        HashMap<Integer, Integer> map = new HashMap<> ();
        int netCnt = 0;
        
        for (int pc = 0; pc < n; pc++) {
            int netId;

            if (map.containsKey(pc)) {
                netId = map.get(pc);
            } else {
                netCnt++;
                netId = netCnt;
            }
            
            for (int pc2 = 0; pc2 < n; pc2++) {
                if (computers[pc][pc2] == 0 || map.containsKey(pc2))
                    continue;
                map.put(pc2, netId);
            }
        }
        
        return netCnt;
    }
}