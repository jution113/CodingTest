class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowLen = arr1.length;
        int colLen = arr2[0].length;
        int[][] answer = new int[rowLen][colLen];
        
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                for (int comLen = 0; comLen < arr1[0].length; comLen++) {
                    answer[row][col] += arr1[row][comLen] * arr2[comLen][col];
                }
            }
        }
        
        return answer;
    }
}