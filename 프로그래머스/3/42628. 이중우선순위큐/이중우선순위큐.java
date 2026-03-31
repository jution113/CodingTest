import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        ArrayList<Integer> que = new ArrayList<> ();
        
        for (String operation : operations) {
            String[] strArr = operation.split(" ");
            
            if (operation.charAt(0) == 'I') {
                que.add(Integer.parseInt(strArr[1]));
                Collections.sort(que);
            } else if (que.size() > 0) {
                if (operation.charAt(2) == '-') {
                    que.remove(0);
                } else {
                    que.remove(que.size() - 1);
                }
            }
        }
        
        int[] answer = {0, 0};
        if (que.size() == 1) {
            answer[0] = que.get(0);
            answer[1] = que.get(0);
        } else if (que.size() > 1) {
            answer[1] = que.get(0);
            answer[0] = que.get(que.size() - 1);
        }
        
        return answer;
    }
}