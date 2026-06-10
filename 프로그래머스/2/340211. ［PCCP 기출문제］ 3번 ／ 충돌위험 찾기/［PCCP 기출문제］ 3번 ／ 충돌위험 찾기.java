import java.util.*;

class Solution {
    private final int MAX_LEN = 100;
    
    private int[][] points;
    private int answer;
    private HashMap<Integer, ArrayList<Integer>>[][] robotIdListBySecTable;
    
    public int solution(int[][] points, int[][] routes) {
        this.points = points;
        answer = 0;
        
        // 테이블 초기화
        robotIdListBySecTable = new HashMap[MAX_LEN][MAX_LEN];
        for (int r = 0; r < MAX_LEN; r++) {
            for (int c = 0; c < MAX_LEN; c++)
                robotIdListBySecTable[r][c] = new HashMap<> ();
        }
        
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            int start = route[0] - 1;
            int sec = 0;

            int r = points[start][0] - 1;
            int c = points[start][1] - 1;
            putId(i, r, c, sec);
            
            for (int j = 1; j < route.length; j++) {
                int end = route[j] - 1;
                sec = move(i, start, end, sec);
                start = end;
            }
        }
        
        return answer;
    }
    
    private int move(int robotId, int start, int end, int sec) {
        int r = points[start][0] - 1;
        int c = points[start][1] - 1;
        int er = points[end][0] - 1;
        int ec = points[end][1] - 1;
        int rDis = Math.abs(er - r);
        int cDis = Math.abs(ec - c);
        int rMoveDir = r < er ? 1 : -1;
        int cMoveDir = c < ec ? 1 : -1;
        
        // r 이동
        for (int i = 0; i < rDis; i++) {
            r += rMoveDir;
            sec++;
            putId(robotId, r, c, sec);
        }
        
        // c 이동
        for (int i = 0; i < cDis; i++) {
            c += cMoveDir;
            sec++;
            putId(robotId, r, c, sec);
        }
        
        return sec;
    }
    
    private void putId(int robotId, int r, int c, int sec) {
        if (robotIdListBySecTable[r][c].containsKey(sec)) {
            ArrayList<Integer> robotIdList = robotIdListBySecTable[r][c].get(sec);
            robotIdList.add(robotId);
                
            // 최초 충돌만 기록에 기입 -> 동일 지점에서의 충돌은 1회만 카운팅하기 위함
            if (robotIdList.size() == 2) {
                answer++;
            }
        } else {
            robotIdListBySecTable[r][c].put(sec, new ArrayList<> (Arrays.asList(robotId)));
        }
    }
}