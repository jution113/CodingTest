import java.util.*;

class Solution {
    private final int MAX_ROTATE = 4;
    private final int DIR_SIZE = 4;
    private final int[] DIR_Y = {-1, 0, 1, 0};
    private final int[] DIR_X = {0, 1, 0, -1};
    
    private int n;
    private int[][] gameBoard;
    private int[][] table;
    private ArrayList<BoardPuzzle> boardPuzzleList;
    private LinkedList<TablePuzzle> tablePuzzleList;
    
    private class BoardPuzzle {
        int size;
        ArrayList<int[]> posInfo = new ArrayList<> ();
        
        public BoardPuzzle(int size, ArrayList<int[]> posInfo) {
            this.size = size;
            ArrayList<int[]> copiedPosInfo = new ArrayList<> (posInfo);
            copiedPosInfo.sort((a, b) -> {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            });
            this.posInfo = copiedPosInfo;
        }
    }
    
    private class TablePuzzle {
        int size;
        ArrayList<int[]>[] posInfos = new ArrayList[MAX_ROTATE];
        
        public TablePuzzle(int size, ArrayList<int[]> posInfo) {
            this.size = size;
            ArrayList<int[]> curPosInfo = new ArrayList<> (posInfo);
            
            for (int r = 0; r < MAX_ROTATE; r++) {
                ArrayList<int[]> rotatedPosInfo = roatePosInfo(curPosInfo);
                rotatedPosInfo.sort((a, b) -> {
                    if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                    return Integer.compare(a[0], b[0]);
                });
                posInfos[r] = rotatedPosInfo;
                curPosInfo = rotatedPosInfo;
            }
        }
        
        private ArrayList<int[]> roatePosInfo(ArrayList<int[]> posInfo) {
            ArrayList<int[]> rotatedPosInfo = new ArrayList<> ();
            int max = 0;
            for (int[] pos : posInfo) max = Math.max(max, pos[0]);
            
            for (int[] pos : posInfo) {
                int y = pos[0];
                int x = pos[1];
                
                rotatedPosInfo.add(new int[] {x, max - y});
            }
            
            return rotatedPosInfo;
        }
    }
    
    public int solution(int[][] gameBoard, int[][] table) {
        n = gameBoard.length;
        this.gameBoard = gameBoard;
        this.table = table;
        boardPuzzleList = new ArrayList<> ();
        tablePuzzleList = new LinkedList<> ();
        int answer = 0;
        
        // 보드 & 태이블에서 퍼즐 추출
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (gameBoard[y][x] == 0)
                    bfs(y, x, gameBoard);
                if (table[y][x] == 1)
                    bfs(y, x, table);
            }
        }
        
        // 칠교놀이
        for (BoardPuzzle boardPuzzle : boardPuzzleList) {
            boolean isValid = false;
            int i = 0;
            
            for (; i < tablePuzzleList.size(); i++) {
                TablePuzzle tablePuzzle = tablePuzzleList.get(i);
                
                // 퍼즐 크기 검사
                if (tablePuzzle.size != boardPuzzle.size)
                    continue;
                
                // 퍼즐 검사
                for (ArrayList<int[]> posInfo : tablePuzzle.posInfos) {
                    if (!validatePuzzle(boardPuzzle.posInfo, posInfo))
                        continue;
                        
                    answer += boardPuzzle.size;
                    isValid = true;
                    break;
                }
                
                if (isValid) {
                    tablePuzzleList.remove(i); // 성공 시 제외
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private boolean validatePuzzle(ArrayList<int[]> posInfoA, ArrayList<int[]> posInfoB) {
        for (int i = 0; i < posInfoA.size(); i++) {
            int[] posA = posInfoA.get(i);
            int[] posB = posInfoB.get(i);
            
            if (posA[0] != posB[0] || posA[1] != posB[1])
                return false;
        }
        
        return true;
    }
    
    private void bfs(int sy, int sx, int[][] table) {
        ArrayDeque<int[]> que = new ArrayDeque<> ();        
        que.offer(new int[] {sy, sx});
                
        ArrayList<int[]> posInfo = new ArrayList<> ();
        int size = 0;
        int stdVal = table[sy][sx];
        table[sy][sx] = -1; // 방문 처리
        
        int minY = sy;
        int minX = sx;
        
        while(!que.isEmpty()) {
            int[] pos = que.poll();
            int y = pos[0];
            int x = pos[1];
            size++;
            posInfo.add(new int[] {y, x});
            minY = Math.min(minY, y);
            minX = Math.min(minX, x);
            
            for (int d = 0; d < DIR_SIZE; d++) {
                int ny = y + DIR_Y[d];
                int nx = x + DIR_X[d];
                
                if (ny < 0 || ny == n || nx < 0 || nx == n)
                    continue;
                if (table[ny][nx] != stdVal)
                    continue;
                
                que.offer(new int[] {ny, nx});
                table[ny][nx] = -1;
            }
        }
        
        for (int[] pos : posInfo) {
            pos[0] -= minY;
            pos[1] -= minX;
        }
        
        if (stdVal == 0) {
            boardPuzzleList.add(new BoardPuzzle(size, posInfo));
        } else {
            tablePuzzleList.add(new TablePuzzle(size, posInfo));
        }
    }
}