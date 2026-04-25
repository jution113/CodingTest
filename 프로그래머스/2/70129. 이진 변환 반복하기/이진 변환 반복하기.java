import java.util.*;

class Solution {
    public int[] solution(String s) {
        if (s.equals("1")) {
            return new int[] {0, 0};
        }
        
        String s2 = s.replace("0", "");
        String binary = intToBinary(s2.length());
        
        int cnt = 1; 
        int len = s.length() - s2.length();
        
        System.out.println(binary);
        
        while (!binary.equals("1")) {
            String newS = binary;
            String newS2 = newS.replace("0", "");
            binary = intToBinary(newS2.length());
            
            cnt++; 
            len += newS.length() - newS2.length();
        }
        
        return new int[] {cnt, len};
    }
    
    private String intToBinary(int n) {
        StringBuilder binary = new StringBuilder();
        
        while (n > 1) {
            binary.append(n % 2);
            n /= 2;
        }
        binary.append(n);
        
        return binary.reverse().toString();
    }
}