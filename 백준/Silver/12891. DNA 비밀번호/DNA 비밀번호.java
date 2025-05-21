import java.io.*;
import java.util.*;

public class Main {
    static int P;
    static int S;
    static String src;
    static int[][] dnaArr;
    static int[] targetCnt = new int[4];
    static int res = 0;
    
    static void dnaCount(int idx) {
        switch (src.charAt(idx - 1)) {
            case 'A':
                dnaArr[0][idx]++;
                break;
            case 'C':
                dnaArr[1][idx]++;
                break;
            case 'G':
                dnaArr[2][idx]++;
                break;
            case 'T':
                dnaArr[3][idx]++;
                break;
        }
    }

    static boolean dnaCheck(int[] dnaCnt) {
        for (int i = 0; i < 4; i++) if (dnaCnt[i] < targetCnt[i]) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        dnaArr = new int[4][P + 1];
        S = Integer.parseInt(st.nextToken());
        src = br.readLine();
        for (int i = 1; i <= P; i++) {
            for (int j = 0; j < 4; j++) dnaArr[j][i] = dnaArr[j][i - 1];
            dnaCount(i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) targetCnt[i] = Integer.parseInt(st.nextToken());
        for (int i = S; i <= P; i++) {
            int[] dnaCnt = new int[4];
            for (int j = 0; j < 4; j++) dnaCnt[j] = dnaArr[j][i] - dnaArr[j][i - S];
            if (dnaCheck(dnaCnt)) res++;
        }
        System.out.println(res);
    }
}
