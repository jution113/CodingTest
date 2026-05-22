import java.util.*;
import java.io.*;

public class Solution {
    private static long min;
    private static int[][] table;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= testCnt; test++) {
            min = Long.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            table = new int[n][n];
            StringTokenizer st;
            for (int r = 0; r < n; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    table[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#" + test + " ");
            comb(0, 0, n / 2, new boolean[n]);
            sb.append(min + "\n");
        }

        System.out.println(sb.toString());
    }

    private static void comb(int start, int depth, int maxDepth, boolean[] peeks) {
        if (depth == maxDepth) {
            validate(peeks);
            return;
        }

        for (int i = start; i < n; i++) {
            peeks[i] = true;
            comb(i + 1, depth + 1, maxDepth, peeks);
            peeks[i] = false;
        }
    }

    private static void validate(boolean[] peeks) {
        long a = 0;
        long b = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (peeks[i] && peeks[j]) {
                    a += table[i][j];
                } else if (!peeks[i] && !peeks[j]) {
                    b += table[i][j];
                }
            }
        }

        min = Math.min(min, Math.abs(a - b));
    }
}