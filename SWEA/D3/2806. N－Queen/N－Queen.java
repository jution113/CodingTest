import java.util.*;
import java.io.*;

class Solution
{
    static int result;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[] queens = new int[N + 1];
            result = 0;
            solve(queens, N, 1);
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void solve(int[] queens, int N, int row) {
        if(row == N + 1) {
            result++;
            return;
        }

        for(int c = 1; c <= N; c++) {
            if(safeCheck(queens, row, c)) {
                queens[row] = c;
                solve(queens, N, row + 1);
            }
        }
    }

    private static boolean safeCheck(int[] queens, int curRow, int nextCol) {
        for(int r = 1; r < curRow; r++) {
            if(nextCol == queens[r] || Math.abs(curRow - r) == Math.abs(nextCol - queens[r])) {
                return false;
            }
        }
        return true;
    }
}