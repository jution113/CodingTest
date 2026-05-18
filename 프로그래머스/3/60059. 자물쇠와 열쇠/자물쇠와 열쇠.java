import java.util.*;

class Solution {
    private int n;
    private int m;
    private int[][] lock;
    
    public boolean solution(int[][] key, int[][] lock) {
        n = lock.length;
        m = key.length;
        this.lock = lock;
        
        ArrayList<int[][]> keys = new ArrayList<> ();
        keys.add(copyMap(key));
        for (int i = 0; i < 3; i++) {
            int[][] rotatedKey = new int[m][m];
            
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < m; x++)
                    rotatedKey[x][m - 1 - y] = key[y][x];
            }
            key = rotatedKey;
            keys.add(copyMap(key));
        }
        
        for (int[][] k : keys) {
            // lock에서 key를 대조해볼 자리 선정
            for (int ly = 0; ly < n; ly++) {
                for (int lx = 0; lx < n; lx++) {
                    // key를 하나씩 대조해볼 시작 자리 선정
                    for (int ky = 0; ky < m; ky++) {
                        for (int kx = 0; kx < m; kx++) {
                            if (validateKey(k, new int[] {ky, kx}, new int[] {ly, lx})) return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    private int[][] copyMap(int[][] origin) {
        int yLen = origin.length;
        int xLen = origin[0].length;
        
        int[][] copied = new int[yLen][xLen];

        for (int y = 0; y < yLen; y++) {
            copied[y] = Arrays.copyOf(origin[y], xLen);
        }
        return copied;
    }
    
    private boolean validateKey(int[][] key, int[] keyStartPos, int[] lockStartPos) {
        int[][] copiedLock = copyMap(lock);
        
        outer:
        for (int ky = keyStartPos[0]; ky < m; ky++) {
            int ly = lockStartPos[0] + ky - keyStartPos[0];
            if (ly >= n) break;
            
            for (int kx = keyStartPos[1]; kx < m; kx++) {
                int lx = lockStartPos[1] + kx - keyStartPos[1];
                if (lx >= n) continue;
                if (copiedLock[ly][lx] == 1 && key[ky][kx] == 1) break outer;
                if (copiedLock[ly][lx] == 0 && key[ky][kx] == 1) copiedLock[ly][lx] = 1;
            }
        }
        
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++)
                if (copiedLock[y][x] == 0) return false;
        }
        
        return true;
    }
}