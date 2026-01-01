class Solution {
    public int solution(int n) {
        int nOneCnt = 0;
        
        nOneCnt = getOneCnt(n);
        do {
            n++;
        } while (nOneCnt != getOneCnt(n));
        
        return n;
    }
    
    static int getOneCnt(int n) {
        int cnt = 0;
        
        while (n > 1) {
            if (n % 2 == 1)
                cnt++;
            n /= 2;
        }
        if (n == 1)
            cnt++;
        return cnt;
    }
}