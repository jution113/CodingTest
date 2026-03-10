class Solution {
    public int solution(int totalPlayer, int[][] results) {
        int[][] resultTable = new int[totalPlayer + 1][totalPlayer + 1];

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            
            resultTable[winner][loser] = 1;
            resultTable[loser][winner] = -1;
        }
        
        for (int mid = 1; mid <= totalPlayer; mid++) {
            for (int start = 1; start <= totalPlayer; start++) {
                for (int end = 1; end <= totalPlayer; end++) {
                    if (resultTable[start][mid] == 1 && resultTable[mid][end] == 1) {
                        resultTable[start][end] = 1;                    
                        resultTable[end][start] = -1;                    
                    } else if (resultTable[start][mid] == -1 && resultTable[mid][end] == -1) {
                        resultTable[start][end] = -1;                    
                        resultTable[end][start] = 1;                    
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= totalPlayer; i++) {
            int resultCnt = 0;
            
            for (int j = 1; j <= totalPlayer; j++) {
                if (resultTable[i][j] != 0) resultCnt++;
            }
            
            if (resultCnt == totalPlayer - 1) answer++;
        }
        
        return answer;
    }
}