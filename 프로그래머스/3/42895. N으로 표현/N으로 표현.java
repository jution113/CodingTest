import java.io.*;
import java.util.*;

class Solution {
    private final int MAX_DEPTH = 8;
    
    public int solution(int N, int number) {
        HashSet<Integer>[] dp = new HashSet[MAX_DEPTH + 1];
        
        for (int depth = 1; depth <= MAX_DEPTH; depth++) {
            dp[depth] = new HashSet<> ();
            
            // N이 이어붙여진 경우의 수 생성
            int concat = 0;
            for (int i = 1; i <= depth; i++) {
                concat *= 10;
                concat += N;
            }
            dp[depth].add(concat);
            
            // depth로 구성할 수 있는 조합의 경우의 수 생성
            for (int i = 1; i < depth; i++) {
                for (int v1 : dp[i]) {
                    for (int v2 : dp[depth - i]) {
                        dp[depth].add(v1 + v2);
                        dp[depth].add(v1 - v2);
                        dp[depth].add(v1 * v2);
                        if (v2 != 0)
                            dp[depth].add(v1 / v2);
                    }
                }
            }
            
            if (dp[depth].contains(number))
                return depth;
        }
        
        return -1;
    }
}