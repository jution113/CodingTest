class Solution {
    public int solution(int n) {
        int nOneCnt = 0;
        
        nOneCnt =  Integer.bitCount(n);
        do {
            n++;
        } while (nOneCnt != Integer.bitCount(n));
        
        return n;
    }
}