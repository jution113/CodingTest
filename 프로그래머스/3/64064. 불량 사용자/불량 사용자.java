import java.util.*;

class Solution {
    static HashSet<HashSet<String>> totalIdSet;
    public int solution(String[] userIdArr, String[] bannedIdArr) {
        totalIdSet = new HashSet<> ();
        
        dfs(0, userIdArr, bannedIdArr, new HashSet<> ());
        
        return totalIdSet.size();
    }
    
    private void dfs(int depth, String[] userIdArr, String[] bannedIdArr, HashSet<String> idSet) {
        if (depth == bannedIdArr.length) {
            totalIdSet.add(new HashSet<> (idSet));
            return;
        }
        
        String bannedId = bannedIdArr[depth];
        for (int i = 0; i < userIdArr.length; i++) {
            String userId = userIdArr[i];
            
            if (validateId(bannedId, userId) && !idSet.contains(userId)) {
                idSet.add(userId);
                dfs(depth + 1, userIdArr, bannedIdArr, idSet);
                idSet.remove(userId);
            }
        }
    }
    
    private boolean validateId(String bannedId, String userId) {
        if (bannedId.length() != userId.length())
            return false;
        
        for (int i = 0; i < bannedId.length(); i++) {
            if (bannedId.charAt(i) != '*' && bannedId.charAt(i) != userId.charAt(i))
                return false;
        }
        return true;
    }
}