import java.io.*;
import java.util.*;

public class Main {
    private static final int DIR_SIZE = 4;
    private static final int[] DIR_Y = {-1, 1, 1, -1};
    private static final int[] DIR_X = {1, 1, -1, -1};
    
    private static int method;
    private static int n;
    private static int map[][];
    private static boolean[] xVisit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        xVisit = new boolean[n];

        method = 0;
        dfs(0, 0);
        
        System.out.println(method);
    }
    
    private static void dfs(int depth, int y) {
        if (depth == n) {
            method++;
            return ;
        }

        for (int x = 0; x < n; x++) {
            // 세로 검사
            if (xVisit[x])
                continue;
            // 대각선 검사
            if (!crossCheck(y, x))
                continue;
                
            xVisit[x] = true;
            map[y][x] = 1;
                
            dfs(depth + 1, y + 1);
                
            xVisit[x] = false;
            map[y][x] = 0;
        }
    }
    
    private static boolean crossCheck(int y, int x) {
        for (int d = 0; d < DIR_SIZE; d++) {
            int ny = y;
            int nx = x;
            
            while ((0 <= ny && ny < n) && (0 <= nx && nx < n)) {
                if (map[ny][nx] == 1)
                    return false;
                
                ny += DIR_Y[d];
                nx += DIR_X[d];
            }
        }
        
        return true;
    }
}