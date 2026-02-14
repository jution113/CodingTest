import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> typeSet = new HashSet<> ();
        int i = 0;
        
        while (i < nums.length && typeSet.size() < nums.length / 2) {
            if (!typeSet.contains(nums[i]))
                typeSet.add(nums[i]);
            i++;
        }
        
        return typeSet.size();
    }
}