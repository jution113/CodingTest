import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t < T; t++) {
	        int N = Integer.parseInt(br.readLine());
            
            int[][] matrix = new int[N + 1][N + 1]; // index 1부터 시작
            int count = 0;
            
            // matrix 초기화
            for(int i = 1; i <= N; i++) {
                String[] row = br.readLine().split(" ");
                for(int j = 0; j < N; j++) matrix[i][j + 1] = Integer.parseInt(row[j]);
            }
            
            // matrix 정렬 검사
            for(int i = N; i >= 1; i--) {
                for(int j = N; j >= 1; j--) {
                    if(matrix[i][j] != (i-1) * N + j) { // 전치 실행 조건
                        transcope(matrix, i);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
	}
    
    private static void transcope(int[][] matrix, int n) {
        for(int i = n; i >= 1; i--) {
            for(int j = i - 1; j >= 1; j--) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}