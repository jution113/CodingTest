import java.util.*;

class Solution {
    static HashSet<HashSet<String>> answer;
    public int solution(String[] userIdArr, String[] bannedIdArr) {
        answer = new HashSet<> ();
        dfs(0, userIdArr, bannedIdArr, new HashSet<> ());
        
        return answer.size();
    }
    
    private void dfs(int depth, String[] userIdArr, String[] bannedIdArr, HashSet<String> idSet) {
        if (depth == bannedIdArr.length) {
            if (!answer.contains(idSet))
                answer.add(new HashSet<> (idSet));
            return ;
        }
        
        for (int i = 0; i < userIdArr.length; i++) {
            if (validateId(userIdArr[i], bannedIdArr[depth]) && !idSet.contains(userIdArr[i])) {
                idSet.add(userIdArr[i]);
                dfs(depth + 1, userIdArr, bannedIdArr, idSet);
                idSet.remove(userIdArr[i]);
            }
        }
    }
    
    private boolean validateId(String userId, String bannedId) {
        if (userId.length() != bannedId.length())
            return false;
        
        for (int i = 0; i < bannedId.length(); i++) {
            if (bannedId.charAt(i) != '*' && bannedId.charAt(i) != userId.charAt(i))
                return false;
        
        }
        return true;
    }
}