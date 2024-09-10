import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> hashMap = new HashMap<> ();        
        
        for(String e : record) {
            if(e.startsWith("Leave")) continue;
            
            String[] splitedE = e.split(" ");
            String uid = splitedE[1];
            String nickName = splitedE[2];
            
            hashMap.put(uid, nickName);
        }
        
        List<String> answer = new ArrayList<> ();
        
        for(String e : record) {
            if(e.startsWith("Change")) continue;
            
            String nickName = hashMap.get(e.split(" ")[1]);
            
            if(e.startsWith("Enter")) {
                answer.add(nickName + "님이 들어왔습니다.");
            } else {
                answer.add(nickName + "님이 나갔습니다.");
            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
}