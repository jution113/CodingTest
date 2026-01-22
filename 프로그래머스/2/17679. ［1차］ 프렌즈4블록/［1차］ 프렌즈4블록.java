import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = mapInit(m, n, board);
        int answer = 0;
        int cnt = 0;
        
        // System.out.println("answer: " + answer + "/ cnt: " + cnt);
        // printMap(m, map);
        do {
            cnt = removeTileCheck(m, n, map);
            answer += cnt;
            clearTile(m, n, map);
            
            // System.out.println("answer: " + answer + "/ cnt: " + cnt);
            // printMap(m, map);
        } while (cnt > 0);
        
        return answer;
    }
    
    private void clearTile(int m, int n, char[][] map) {
        for (int c = 0; c < n; c++) {
            for (int repeatCnt = 0; repeatCnt < m - 1; repeatCnt++) {
                for (int r = m - 1; r > 0 + repeatCnt; r--) {
                    if (map[r][c] == '.') {
                        map[r][c] = map[r - 1][c];
                        map[r - 1][c] = '.';
                        
                    }
                }
            }
        }
    }
    
    private int removeTileCheck(int m, int n, char[][] map) {
        boolean[][] removeCheckMap = new boolean[m][n];
        
        for (int r = 0; r < m - 1; r++) {
             for (int c = 0; c < n - 1; c++) {
                 char standard = map[r][c];
                 
                 if (standard == '.')
                     continue;
                 
                 if (standard == map[r + 1][c] && standard == map[r][c + 1] && standard == map[r + 1][c + 1]) {
                     removeCheckMap[r][c] = true;
                     removeCheckMap[r + 1][c] = true;
                     removeCheckMap[r][c + 1] = true;
                     removeCheckMap[r + 1][c + 1] = true;
                 }
             }
        }
        
        return removeAndCountTile(m, n, map, removeCheckMap);
    }
    
    private int removeAndCountTile (int m, int n, char[][] map, boolean[][] removeCheckMap) {
        int cnt = 0;
        
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (removeCheckMap[r][c]) {
                        map[r][c] = '.';
                        cnt++;
                    }
                }
            }
        return cnt;
    }
    
    private char[][] mapInit(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        
        for (int r = 0; r < m; r++) {
            map[r] = board[r].toCharArray();
        }
        
        return map;
    }
    
    // private void printMap(int m, char[][] map) {
    //     for (int r = 0; r < m; r++) {
    //         System.out.println(Arrays.toString(map[r]));
    //     }
    //     System.out.println("----- ----- -----");
    // }
}