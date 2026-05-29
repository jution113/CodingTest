import java.util.*;

class Solution {
    private int[][] lock;
    
    public boolean solution(int[][] key, int[][] lock) {
        this.lock = lock;
        
        ArrayList<int[][]> keyList = new ArrayList<> ();
        keyList.add(copyTable(key));
        for (int i = 0; i < 3; i++) {
            rotateTable(key);
            keyList.add(copyTable(key));
        }
        
        int hole = countHole(lock);
        int n = lock.length;
        int m = key.length;
        
        for (int[][] rotatedKey : keyList) {
            
            for (int sy = 0 - (m - 1); sy < n; sy++) {
                keyCheck:
                for (int sx = 0 - (m - 1); sx < n; sx++) {
                    int fill = 0;

                    for (int keyY = 0; keyY < m; keyY++) {
                        int y = sy + keyY;
                        for (int keyX = 0; keyX < m; keyX++) {
                            int x = sx + keyX;
                            if (y < 0 || x < 0 || y >= n || x >= n) continue;
                            if (lock[y][x] == 1 && rotatedKey[keyY][keyX] == 1) continue keyCheck;
                            if (lock[y][x] == 0 && rotatedKey[keyY][keyX] == 1) fill++;
                        }
                    }
                    
                    if (fill == hole) return true;
                }
            }
        }
        return false;
    }
    
    private void rotateTable(int[][] table) {
        int n = table.length;
        int[][] copiedTable = copyTable(table);
        
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                table[y][x] = copiedTable[x][n - 1 - y];
            }
        }
    }
    
    private int[][] copyTable(int[][] originTable) {
        int n = originTable.length;
        int[][] copiedTable = new int[n][n];
        
        for (int i = 0; i < n; i++)
            copiedTable[i] = Arrays.copyOf(originTable[i], n);
        
        return copiedTable;
    }
    
    private int countHole(int[][] table) {
        int n = table.length;
        int hole = 0;
        
        for (int y = 0 ; y < n; y++) {
            for (int x = 0 ; x < n; x++) {
                if (table[y][x] == 0) hole++;
            }
        }
        
        return hole;
    }
    
//     private void printTalbe(int[][] table) {
//         int n = table.length;
        
//         System.out.println("-----");
        
//         for (int i = 0; i < n; i++)
//             System.out.println(Arrays.toString(table[i]));
//     }
}