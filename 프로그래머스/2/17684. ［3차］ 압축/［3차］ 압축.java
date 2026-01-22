import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<> ();
        Map<String, Integer> dict = new HashMap<> ();
        
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf(((char) (65 + i))), i + 1);
        }
        
        int i = 0;
        
        a: while (i < msg.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));
            int idx = -1;
            
            while (dict.containsKey(sb.toString())) {
                idx = dict.get(sb.toString());
                if (i + 1 < msg.length()) {
                    i++;
                    sb.append(msg.charAt(i));
                } else {
                    answer.add(idx);
                    break a;
                }
            }
            
            answer.add(idx);
            dict.put(sb.toString(), dict.size() + 1);
        }
        
        return answer.stream()
            .mapToInt(e -> e)
            .toArray();
    }
}
