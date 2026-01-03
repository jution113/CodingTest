import java.util.*;
import java.io.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                ans++;
            }
        }

        return ans;
    }
}

/*
[동작]
1. k 칸 앞으로 이동 / 건전지 소모 O
2. 현재 위치 * 2 이동 / 건전지 소모 X

[입력]
- 목적지 N(1 ~ 10^9)
- O(N) 이하여야 함.

[출력]
- 필요한 건전지 최소량

[sudo code]
1. N을 2로 나눠 나머지가 1인지 0인지 구분
1.1. 나머지가 1일 경우, 1을 뺀다.(건전지 1개 소모)
1.2. 나머지가 0일 경우, 2로 나눈다.(건전지 0개 소모)

*/