import java.util.*;

class Solution {
    /*
    * @pram : int[] progresses, 해당 작업의 진행률
    * @parma : int[] speeds, 일률
    * @return : int[],  각 배포마다 몇 개의 기능이 배포되는지를 담은 배열
    * 
    * 제약 사항 1 : 개발은 병렬 / 배포는 순차
    * 제약 사항 2 : 배포는 하루 1번(하루의 끝)
    *
    * 전제 조건 1 : progresses, speeds의 길이는 100 이하
    */
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<> ();
        ArrayDeque<Integer> orderedProgresses = new ArrayDeque<> ();
        int order = 0;
        int day = 0;
        
        // 작업 순서 부여
        for (int progress : progresses) {
            orderedProgresses.offer(progress);
        }
        
        while(order < progresses.length) {
            int finished = 0;
            
            day++;
            
            while (!orderedProgresses.isEmpty() && orderedProgresses.peek() + (speeds[order] * day) >= 100) {
                orderedProgresses.poll();
                order++;
                finished++;
            }
            
            if (finished > 0) answer.add(finished);
        }
        
        return listToArray(answer);
    }
    
    
    private int[] listToArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}