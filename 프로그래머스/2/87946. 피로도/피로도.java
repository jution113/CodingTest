import java.util.*;

class Solution {
    static int MAX = 0;
    static int[][] gDungeons;
    static boolean[] gVisited;
    
    public int solution(int k, int[][] dungeons) {
        gDungeons = dungeons;
        int n = gDungeons.length;
        gVisited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            dfs(k, i, 0);
        }
        return MAX;
    }
    
    private void dfs(int k, int start, int cnt) {
        int[] dungeon = gDungeons[start];
        
        if (k >= dungeon[0]) {
            MAX = Math.max(MAX, cnt + 1);
            gVisited[start] = true;
            
            for (int i = 0; i < gDungeons.length; i++) {
                if (!gVisited[i])
                    dfs(k - dungeon[1], i, cnt + 1);
            }
        }
        
        gVisited[start] = false;
    }
}