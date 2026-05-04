import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                map[y][x] = y * columns + (x + 1);
            }
        }
        
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int y1 = query[0] - 1;
            int x1 = query[1] - 1;
            int y2 = query[2] - 1;
            int x2 = query[3] - 1;
                        
            int tmp = map[y1][x1];
            int tmp2 = map[y1][x2];
            int tmp3 = map[y2][x2];
            int tmp4 = map[y2][x1];

            int min = Math.min(tmp, tmp2);
            min = Math.min(min, tmp3);
            min = Math.min(min, tmp4);
            
            for (int x = x2; x > x1; x--) {
                map[y1][x] = map[y1][x - 1];
                min = Math.min(min, map[y1][x - 1]);
            }
            
            for (int y = y2; y > y1; y--) {
                map[y][x2] = map[y - 1][x2];
                min = Math.min(min, map[y - 1][x2]);
            }
            
            for (int x = x1; x < x2; x++) {
                map[y2][x] = map[y2][x + 1];
                min = Math.min(min, map[y2][x + 1]);
            }
            
            for (int y = y1; y < y2; y++) {
                map[y][x1] = map[y + 1][x1];
                min = Math.min(min, map[y + 1][x1]);
            }
            
            map[y1][x1 + 1] = tmp;
            map[y1 + 1][x2] = tmp2;
            map[y2][x2 - 1] = tmp3;
            map[y2 - 1][x1] = tmp4;
            
            answer[i] = min;
        }
        
        return answer;
    }
}