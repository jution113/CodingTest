import java.util.*;

class Solution {
    private HashSet<String> prefixSet;
    
    public boolean solution(String[] phone_book) {
        prefixSet = new HashSet<> ();
        
        Arrays.sort(phone_book);
        
        for (String phone : phone_book) {
            if (validatePhone(phone))
                return false;
        }
        return true;
    }
    /*
    @parm : String phone 접두사, 중복을 검사할 전화번호
    @return : 접두사의 중복 여부, true(중복 존재) / false(중복 없음)
    */
    private boolean validatePhone(String phone) {
        if (prefixSet.isEmpty()) {
            prefixSet.add(phone);
            return false;
        }
        
        for (int i = 0; i < phone.length(); i++) {
            if (prefixSet.contains(phone.substring(0, i)))
                return true;
        }
        
        prefixSet.add(phone);
        return false;
    } 
}