import java.io.*;
import java.util.*;

public class Main {    
    private static int method;
    private static int n;
    private static int[] queenPos;
    private static boolean[] xVisit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        queenPos = new int[n];
        Arrays.fill(queenPos, -1);
        xVisit = new boolean[n];

        method = 0;
        dfs(0);
        
        System.out.println(method);
    }
    
    private static void dfs(int y) {
        if (y == n) {
            method++;
            return ;
        }

        for (int x = 0; x < n; x++) {
            if (xVisit[x] || !crossCheck(y, x))
                continue;
                
            xVisit[x] = true;
            queenPos[y] = x;
            dfs(y + 1);
            queenPos[y] = -1;
            xVisit[x] = false;
        }
    }
    
    private static boolean crossCheck(int y, int x) {
        int rx = x;
        int lx = x;
        
        for (int i = 1; i <= y; i++) {
            if (rx + 1 < n) {
                if (queenPos[y - i] == ++rx) return false;
            }
            if (lx - 1 >= 0) {
                if (queenPos[y - i] == --lx) return false;
            }
        }
        return true;
    }
}