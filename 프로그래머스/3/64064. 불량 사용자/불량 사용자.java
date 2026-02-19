import java.util.*;

class Solution {
    String[] userIdArr;
    String[] bannedIdArr;
    HashSet<HashSet<String>> bannedIdCombSet;
    
    public int solution(String[] user_id, String[] banned_id) {
        userIdArr = user_id;
        bannedIdArr = banned_id;
        bannedIdCombSet = new HashSet<> ();
        
        comb(0, new HashSet<> ());
        
        return bannedIdCombSet.size();
    }
    
    private void comb(int depth, HashSet<String> bannedIdComb) {
        if (depth == bannedIdArr.length) {
            bannedIdCombSet.add(new HashSet<> (bannedIdComb));
            return;
        }
        
        String bannedId = bannedIdArr[depth];
        
        for (String userId : userIdArr) {
            if (!bannedIdComb.contains(userId) && validate(bannedId, userId)) {
                bannedIdComb.add(userId);
                comb(depth + 1, bannedIdComb);
                bannedIdComb.remove(userId);
            }
        }
    }
    
    private boolean validate(String bannedId, String userId) {
        if (bannedId.length() != userId.length()) {
            return false;
        }
        for (int i = 0; i < bannedId.length(); i++) {
            if (bannedId.charAt(i) != '*' && bannedId.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}