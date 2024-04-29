import java.util.*;
import java.io.*;

public class Main {
    static final int POLE_CNT = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] gears = new int[T + 1][POLE_CNT + 1];

        for(int i = 1; i <= T; i++) {
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++) {
                gears[i][j + 1] = input.charAt(j) - '0';
            }
        }

        int[] totalMoveCnt = new int[T + 1];

        int K = Integer.parseInt(br.readLine());
        for(int i = 1; i <= K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            int[] subMoveCnt = new int[T + 1];
            subMoveCnt[pos] = dir;

            for(int r = pos; r < T; r++) {
                if(gears[r][getEditedPoleIdx(totalMoveCnt[r], 3)] != gears[r + 1][getEditedPoleIdx(totalMoveCnt[r + 1], 7)]) {
                    subMoveCnt[r + 1] += subMoveCnt[r] * - 1;
                    continue;
                }
                break;
            }

            for(int l = pos; l > 1; l--) {
                if(gears[l][getEditedPoleIdx(totalMoveCnt[l], 7)] != gears[l - 1][getEditedPoleIdx(totalMoveCnt[l - 1], 3)]) {
                    subMoveCnt[l - 1] += subMoveCnt[l] * - 1;
                    continue;
                }
                break;
            }

            for(int j = 1; j <= T; j++) {
                totalMoveCnt[j] += subMoveCnt[j];
            }
        }

        int sPoleCnt = 0;

        for(int i = 1; i <= T; i++) {
            if(gears[i][getEditedPoleIdx(totalMoveCnt[i], 1)] == 1) sPoleCnt++;
        }

        System.out.println(sPoleCnt);
    }

    static int getEditedPoleIdx(int moveCnt, int poleIdx) {
        int editedPoleIdx = (poleIdx - 1 * moveCnt) % 8;
        if(editedPoleIdx == 0) return 8;
        if(editedPoleIdx < 0) return 8 + editedPoleIdx;
        return editedPoleIdx;
    }
}
