import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int lcm = arr[arr.length - 1];
        
        while (!isLCM(lcm, arr)) {
            lcm += arr[arr.length - 1];
        }
        return lcm;
    }
    
    boolean isLCM(int n, int[] arr) {
        for(int i : arr) {
            if (n % i != 0)
                return false;
        }
        return true;
    }
}