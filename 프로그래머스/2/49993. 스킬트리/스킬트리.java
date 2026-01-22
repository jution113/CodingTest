import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> map = new HashMap<> ();
        int answer = 0;
        
        for (int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }

        for (String skill_tree : skill_trees) {
            int i = 0;
            boolean flag = true;
            
            for (char c : skill_tree.toCharArray()) {
                if (map.containsKey(c)) {
                    if (map.get(c) == i) {
                        i++;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag)
                answer++;
        }
        
        return answer;
    }
}