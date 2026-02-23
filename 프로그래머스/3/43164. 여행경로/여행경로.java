import java.util.*;

class Solution {
    HashMap<String, ArrayList<String>> endListByStart;
    HashMap<String, boolean[]> visitedListByStart;
    ArrayList<String> answerList;
    int max;
    
    public String[] solution(String[][] tickets) {
        endListByStart = new HashMap<> ();
        visitedListByStart = new HashMap<> ();
        answerList = new ArrayList<String> ();
        max = tickets.length + 1;
        
        // '출발지 : 목적지' 리스트 초기화
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            
            endListByStart.computeIfAbsent(start, k -> new ArrayList<> ()).add(end);
        }
        
        // '출발지 : 목적지' 리스트 정렬, '출발지 : 목적지' 방문 여부 리스트 초기화
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            
            endListByStart.get(start).sort(Comparator.naturalOrder());
            visitedListByStart.computeIfAbsent(start, k -> new boolean[endListByStart.get(start).size()]);
        }
        
        answerList.add("ICN");
        dfs("ICN");
        
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    private void dfs(String start) {        
        ArrayList<String> endList = endListByStart.getOrDefault(start, new ArrayList<> ());
        if (endList.size() == 0) {
            return;
        }
        
        boolean[] visitedList = visitedListByStart.get(start);
        
        for (int i = 0; i < endList.size(); i++) {
            String end = endList.get(i);
            
            if (!visitedList[i]) {
                visitedList[i] = true;
                visitedListByStart.put(start, visitedList);
                
                answerList.add(end);
                if (answerList.size() == max) {
                    return;
                }
                dfs(end);
                if (answerList.size() == max) {
                    return;
                }
                answerList.remove(answerList.size() - 1);
                
                visitedList[i] = false;
                visitedListByStart.put(start, visitedList);
            }
        }
        
        
    }
}