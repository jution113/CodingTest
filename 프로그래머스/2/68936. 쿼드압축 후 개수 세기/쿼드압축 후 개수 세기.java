class Solution {
    static int[][] arr;
    static int[] answer;
    
    
    public int[] solution(int[][] src) {
        arr = src;
        answer = new int[2];
        int n = arr.length;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (arr[r][c] == 0) {
                    answer[0]++;
                } else {
                    answer[1]++;
                }
            }
        }
        
        zip(0, 0, n);
        
        return answer;
    }
    
    private void zip(int r1, int c1, int n) {
        if (n == 1)
            return;
        
        if (isZip(r1, c1, n)) {
            int num = arr[r1][c1];
            answer[num] = answer[num] - (n * n) + 1;
            return;
        }
        
        int half = n / 2;
        
        zip(r1, c1, half);
        zip(r1, c1 + half, half);
        zip(r1 + half, c1, half);
        zip(r1 + half, c1 + half, half);
    }
    
    private boolean isZip(int r1, int c1, int n) {
        int temp = arr[r1][c1];
        
        for (int r = r1; r < r1 + n; r++) {
            for (int c = c1; c < c1 + n; c++) {
                if (arr[r][c] != temp)
                    return false;
            }
        }
        
        return true;
    }
}