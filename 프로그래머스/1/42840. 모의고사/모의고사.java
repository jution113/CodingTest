import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] pattern1 = new int[] {1, 2, 3, 4, 5};
        int[] pattern2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] points = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == pattern1[i % pattern1.length]) points[0]++;
            if(answers[i] == pattern2[i % pattern2.length]) points[1]++;
            if(answers[i] == pattern3[i % pattern3.length]) points[2]++;
        }
        
        ArrayList<Integer> arrList = new ArrayList<> ();
        arrList.add(1);
        
        for(int i = 1; i < 3; i++) {
            int max = points[arrList.get(0) - 1];
            
            if(max < points[i]) {
                arrList.clear();
                arrList.add(i + 1);
            } else if(max == points[i]) {
                arrList.add(i + 1);
            }
        }
        
        int[] answer = arrList.stream().mapToInt(i -> i.intValue()).toArray();
        return answer;
    }
}