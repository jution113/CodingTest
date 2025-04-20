import java.io.*;
import java.util.*;


public class Main {
    static int res = 0;
    static int N = 0;
    static int L = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        solveH();
        solveV();
        System.out.println(res);
    }

    static void solveH() {
        next:
        for (int r = 1; r <= N; r++) {
            int prevH = map[r][1];
            int curL = 1;
            boolean[] isUsed = new boolean[N + 1];

            for (int c = 2; c <= N; c++) {
                int curH = map[r][c];
                if (curH != prevH) {
                    if (Math.abs(curH - prevH) > 1) continue next;
                    if (curH > prevH) {
                        if (curL < L) continue next;
                        for (int i = 1; i <= L; i++) {
                            if (isUsed[c - i]) continue next;
                            isUsed[c - i] = true;
                        }
                    } else {
                        if (N - c + 1 < L) continue next;
                        for (int i = 0; i < L; i++) {
                            if (map[r][c + i] != curH) continue next;
                            isUsed[c + i] = true;
                        }
                    }
                    curL = 1;
                } else {
                    curL++;
                }
                prevH = curH;
            }
            res++;
        }
    }

    static void solveV() {
        next:
        for (int c = 1; c <= N; c++) {
            int prevH = map[1][c];
            int curL = 1;
            boolean[] isUsed = new boolean[N + 1];

            for (int r = 2; r <= N; r++) {
                int curH = map[r][c];
                if (curH != prevH) {
                    if (Math.abs(curH - prevH) > 1) continue next;
                    if (curH > prevH) {
                        if (curL < L) continue next;
                        for (int i = 1; i <= L; i++) {
                            if (isUsed[r - i]) continue next;
                            isUsed[r - i] = true;
                        }
                    } else {
                        if (N - r + 1 < L) continue next;
                        for (int i = 0; i < L; i++) {
                            if (map[r + i][c] != curH) continue next;
                            isUsed[r + i] = true;
                        }
                    }
                    curL = 1;
                } else {
                    curL++;
                }
                prevH = curH;
            }
            res++;
        }
    }
}
