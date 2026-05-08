import java.util.*;

class Solution {
    private final int DIR_SIZE = 4;
    private final int[] DIR_Y = {-1, 0, 1, 0};
    private final int[] DIR_X = {0, 1, 0, -1};
    
    private int hLen;
    private int wLen;
    private int answer;
    private char[][] containerMap;
    
    
    public int solution(String[] storage, String[] requests) {
        hLen = storage.length;
        wLen = storage[0].length();
        answer = hLen * wLen;
        containerMap = new char[hLen][wLen];
        
        HashSet<Character> containrType = new HashSet<> ();
        for (int h = 0; h < hLen; h++) {
            for (int w = 0; w < wLen; w++) {
                containerMap[h][w] = storage[h].charAt(w);
                containrType.add(containerMap[h][w]);
            }
        }
        
        for (String request : requests) {
            char target = request.charAt(0);
            if (!containrType.contains(target)) continue;
            
            if (request.length() > 1) {
                craine(target);
            } else {
                forkLift(target);
            }
        }
        
        return answer;
    }
    
    private void craine(char target) {
        for (int h = 0; h < hLen; h++) {
            for (int w = 0; w < wLen; w++) {
                if (containerMap[h][w] == target) {
                    containerMap[h][w] = '.';
                    answer--;        
                }
            }
        }
    }
    
    private void forkLift(char target) {
        char[][] copiedContainerMap = new char[hLen][wLen];
        for (int h = 0; h < hLen; h++) {
            copiedContainerMap[h] = Arrays.copyOf(containerMap[h], wLen);
        }
        
        for (int h = 0; h < hLen; h++) {
            for (int w = 0; w < wLen; w++) {
                if (containerMap[h][w] != target) continue;

                ArrayDeque<int[]> que = new ArrayDeque<> ();
                que.offer(new int[] {h, w});
                
                boolean[][] visit = new boolean[hLen][wLen];
                visit[h][w] = true;
                
                outer:
                while (!que.isEmpty()) {
                    int[] cur = que.poll();

                    for (int d = 0; d < DIR_SIZE; d++) {
                        int ny = cur[0] + DIR_Y[d];
                        int nx = cur[1] + DIR_X[d];

                        if (ny < 0 || ny == hLen || nx < 0 || nx == wLen) {
                            copiedContainerMap[h][w] = '.';
                            answer--;
                            break outer;
                        }
                        if (visit[ny][nx]) continue;
                        visit[ny][nx] = true;
                        if (containerMap[ny][nx] == '.') que.offer(new int[] {ny, nx});
                    }
                }
                
            }
        }
        
        containerMap = copiedContainerMap;
    }
}