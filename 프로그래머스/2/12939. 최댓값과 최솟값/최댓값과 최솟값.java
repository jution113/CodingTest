import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        int[] iArr = Arrays.stream(s.split(" "))
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();
        
        String answer = iArr[0] + " " + iArr[iArr.length - 1];
        return answer;
    }
}