import java.util.*;
import java.io.*;

public class Main {
    static int R = 0;
    static int C = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // 맵 생성
        int[][] map = new int[R + 1][C + 1];
        int cleanerPos = 0;

        for(int r = 1; r <= R; r++) {
            st = new StringTokenizer(br.readLine());

            for(int c = 1; c <= C; c++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == -1) cleanerPos = r;
                map[r][c] = num;
            }
        }

        for(int t = 1; t <= T; t++) {
            spread(map);
            // 위쪽 청소
            move(map, cleanerPos - 2, 1, 1, 1, 'u');
            move(map, 1, 1, 1, C, 'r');
            move(map, 1, C, cleanerPos - 1, C, 'd');
            move(map, cleanerPos - 1, C, cleanerPos - 1, 2, 'l');
            // 아래쪽 청소
            move(map, cleanerPos + 1, 1, R, 1, 'd');
            move(map, R, 1, R, C, 'r');
            move(map, R, C, cleanerPos, C, 'u');
            move(map, cleanerPos, C, cleanerPos, 2, 'l');
        }

        int sum = 0;

        for(int r = 1; r <= R; r++) {
            for(int c = 1; c <= C; c++) {
                if(map[r][c] != -1) sum += map[r][c];
            }
        }

        System.out.println(sum);

    }

    static void move(int[][] map, int curR, int curC, int endR, int endC, char moveDir) {
        switch(moveDir) {
            case 'u':
                curR--;

                while(curR >= endR) {
                    map[curR + 1][curC] = map[curR][curC];
                    curR--;
                }
                break;
            case 'd':
                curR++;

                while(curR <= endR) {
                    map[curR - 1][curC] = map[curR][curC];
                    curR++;
                }
                break;
            case 'r':
                curC++;

                while(curC <= endC ) {
                    map[curR][curC - 1] = map[curR][curC];
                    curC++;
                }
                break;
            default:
                curC--;

                while( curC >= endC ) {
                    map[curR][curC + 1] = map[curR][curC];
                    curC--;
                }
        }

        map[endR][endC] = 0;

    }

    static void spread(int[][] originMap) {
        final int[] DIR_Y = {1, 0, -1, 0};
        final int[] DIR_X = {0, 1, 0, -1};

        int[][] copyMap = new int[R + 1][C + 1];

        // 먼지가 확산 결과 생성
        for(int r = 1; r <= R; r++) {
            for(int c = 1; c <= C; c++) {
                int curNum = originMap[r][c];
                if(curNum < 5) continue;
                int spreadCnt = 0;
                int spreadNum = curNum / 5;

                for(int i = 0; i < 4; i++) {
                    int nextR = r + DIR_Y[i];
                    int nextC = c + DIR_X[i];
                    if(nextR < 1 || R < nextR) continue;
                    if(nextC < 1 || C < nextC) continue;
                    if(originMap[nextR][nextC] == -1) continue;
                    copyMap[nextR][nextC] += spreadNum;
                    spreadCnt++;
                }
                copyMap[r][c] += -1 * spreadNum * spreadCnt;
            }
        }

        // 원본 맵에 먼지 확산 결과 적용
        for(int r = 1; r <= R; r++) {
            for(int c = 1; c <= C; c++) {
                originMap[r][c] += copyMap[r][c];
            }
        }
    }
}
