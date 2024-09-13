import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // Map<신고 당한 자, Set<신고자>>
        Map<String, Set<String>> hashMap = new HashMap<> ();
        // Map<신고자, 메일 받을 횟수>
        Map<String, Integer> hashMap2 = new HashMap<> ();
        
        for(String r : report) {
            String reportingUser = r.split(" ")[0];
            String reportedUser = r.split(" ")[1];
            
            if(!hashMap.containsKey(reportedUser)) hashMap.put(reportedUser, new HashSet<> ());
            hashMap.get(reportedUser).add(reportingUser);
            
            hashMap2.put(reportingUser, 0);
        }
        
        int n = id_list.length;
        int[] answer = new int[n];
        
        hashMap.entrySet().stream()
            // 신고 당한 횟수가 k 이상인 Set<신고자>을 필터링
            .filter(entrySet -> entrySet.getValue().size() >= k)
            .flatMap(entrySet -> entrySet.getValue().stream())
            .forEach(reportingUser -> {
                hashMap2.put(reportingUser, hashMap2.get(reportingUser) + 1);
            });
        
        for(int i = 0; i < n; i++) {
            String user = id_list[i];
            if(hashMap2.containsKey(user)) answer[i] = hashMap2.get(user);
        }
        
        return answer;
    }
}