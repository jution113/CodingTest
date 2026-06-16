import java.util.*;

class Solution {
    private final int SCORE_IDX = 4;
    
    private HashMap<String, ArrayList<Integer>> scoreListByInfo;
    
    public int[] solution(String[] infos, String[] queries) {
        scoreListByInfo = new HashMap<> ();
        int[] answer = new int[queries.length];

        for (String info : infos) dfs(0, info.split(" "), new ArrayList<> ());
        for (Map.Entry<String, ArrayList<Integer>> entrySet : scoreListByInfo.entrySet()) Collections.sort(entrySet.getValue());
        
        
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i].replace(" and ", " ").split(" ");
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < SCORE_IDX; j++) sb.append(query[j] + " ");
            String key = sb.toString();
            
            if (!scoreListByInfo.containsKey(key)) {
                answer[i] = 0;
                continue;
            }
            
            ArrayList<Integer> scoreList = scoreListByInfo.get(key);

            int l = 0;
            int r = scoreList.size() - 1;
            int m = (l + r) / 2;
            int score = Integer.parseInt(query[SCORE_IDX]);
            
            if (scoreList.get(r) < score) {
                answer[i] = 0;
                continue;
            }
            
            while (l < r) {
                if (scoreList.get(m) >= score) {
                    r = m;
                } else {
                    l = m + 1;
                }
                m = (l + r) / 2;
            }
            
            answer[i] = scoreList.size() - l;
        }
                
        return answer;
    }
    
    private void dfs(int start, String[] info, ArrayList<String> peeks) {
        if (start == SCORE_IDX) {
            StringBuilder sb = new StringBuilder();
            for (String peek : peeks) sb.append(peek + " ");
            String key = sb.toString();
            if (!scoreListByInfo.containsKey(key))
                scoreListByInfo.put(key, new ArrayList<> ());
            scoreListByInfo.get(key).add(Integer.parseInt(info[SCORE_IDX]));
            return;
        }
        
        peeks.add(info[start]);
        dfs(start + 1, info, peeks);
        peeks.remove(peeks.size() - 1);
            
        peeks.add("-");
        dfs(start + 1, info, peeks);
        peeks.remove(peeks.size() - 1);
    }
}