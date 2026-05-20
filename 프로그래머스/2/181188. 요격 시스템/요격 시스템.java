import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
//         for (int[] target : targets) {
//             System.out.println(Arrays.toString(target));
//         }
        
        int[] defence = {0 ,0};
        int answer = 0;
        
        for (int[] target : targets) {
            int ts = target[0];
            int te = target[1];
            int ds = defence[0];
            int de = defence[1];
            
            if (de <= ts) {
                defence[0] = ts;
                defence[1] = te;
                answer++;
                continue;
            }
            
            if (ds < ts) defence[0] = ts;
            if (te < de) defence[1] = te;
            
            // System.out.println(Arrays.toString(defence) + " - new");
        }
        
        return answer;
    }
}