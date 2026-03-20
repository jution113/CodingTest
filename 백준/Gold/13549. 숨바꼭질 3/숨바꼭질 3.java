import java.io.*;
import java.util.*;

public class Main {
    private static int start;
    private static int end;
    private static int[] memo;
    private static final int MOVE_WAY_SIZE = 3;
    private static final int[] MOVE_WAY = {-1, 1, 2};
    
    private static void bfs(int[] startInfo) {
        ArrayDeque<int[]> que = new ArrayDeque<> ();
        que.offer(startInfo);
        
        while (!que.isEmpty()) {
            int[] curInfo = que.poll();
            int pos = curInfo[0];
            int time = curInfo[1];
            
            for (int w = 0; w < MOVE_WAY_SIZE; w++) {
                int nextPos = w < 2 ? pos + MOVE_WAY[w] : pos * MOVE_WAY[w];
                int nextTime =  w < 2 ? time + 1 : time;
                
                if ((nextPos >= 0 && nextPos < memo.length) && (nextTime < memo[nextPos])) {
                    memo[nextPos] = nextTime;
                    que.offer(new int[] {nextPos, nextTime});
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        memo = new int[200000];
        Arrays.fill(memo, 100001);
        memo[start] = 0;
        
        // int[0]: position, int[0]: time
        bfs(new int[] {start, 0});
        
        System.out.println(memo[end]);
    }
}