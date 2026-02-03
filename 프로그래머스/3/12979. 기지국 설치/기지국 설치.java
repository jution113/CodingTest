class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int width = (2 * w + 1);
        int i = 0;
        
        for (int station : stations) {
            int end = station - w;
            
            if (end > start) {
                int cnt = (end - start) % width == 0 ? 0 : 1;

                cnt += (end - start) / width;
                answer += cnt;
            }
            
            start = station + w + 1;
            i++;
        }
        
        if (start < n + 1) {
            int cnt = (n + 1 - start) % width == 0 ? 0 : 1;
            cnt += (n + 1 - start) / width;
            answer += cnt;
        }
        
        return answer;
    }
}