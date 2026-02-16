import java.util.*;

class Solution {
    public String solution(int n) {
        char[] base = {'1', '2', '4'};
        
        ArrayList<Character> charList = new ArrayList<> ();
        
        while (n - 1 >= 3) {
            charList.add(base[(n - 1) % 3]);
            n = (n - 1) / 3;
        }
        charList.add(base[n - 1]);
        
        StringBuilder sb = new StringBuilder();
        for (int i = charList.size() - 1; i >= 0; i--) {
            sb.append(charList.get(i));
        }
        
        return sb.toString();
    }
}