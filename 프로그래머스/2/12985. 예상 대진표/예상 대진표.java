class Solution
{
    public int solution(int n, int a, int b)
    {
        int roundCnt = 1;
        
        while (!isMeet(a, b)) {
            a = a % 2 == 0 ? a / 2 : (a + 1) / 2;
            b = b % 2 == 0 ? b / 2 : (b + 1) / 2;
            roundCnt++;
        }
        
        return roundCnt;
    }
    
    private boolean isMeet(int a, int b) {
        return a % 2 == 0 ? a == b + 1 : a == b - 1;
    }
}