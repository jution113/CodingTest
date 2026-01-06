class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        long start = left;

        for (int i = 0; i < answer.length; i++) {
            long row = start / n;
            long col = start % n;
        
            if (col <= row) {
                answer[i] = (int) row + 1;
            } else {
                answer[i] = (int) ((col - row) + row) + 1;
            }
            start++;
        }
        return answer;
    }
}