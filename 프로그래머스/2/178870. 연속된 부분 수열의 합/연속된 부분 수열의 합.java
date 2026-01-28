class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int length = Integer.MAX_VALUE;
        int sum = 0;
        
        for (int end = 0; end < sequence.length; end++) {
            sum += sequence[end];
            
            while (sum > k) {
                sum -= sequence[start++];
            }
            
            if (sum == k && end - start < length) {
                answer[0] = start;
                answer[1] = end;
                length = end - start;
            }
        }
        
        return answer;
    }
}