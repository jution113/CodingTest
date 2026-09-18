import java.util.*;

class Solution {
    private int answer;
    
    public int solution(String[][] clothes) {        
        HashMap<String, Integer> cntByCloth = new HashMap<> ();
        
        for (String[] cloth : clothes) {
            cntByCloth.put(cloth[1], cntByCloth.getOrDefault(cloth[1], 0) + 1);
        }
        
        int product = 1;
        
        for (int cnt : cntByCloth.values()) {
            product *= cnt + 1;
        }
        
        return product - 1;
    }
}