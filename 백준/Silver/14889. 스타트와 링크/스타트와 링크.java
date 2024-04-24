import java.io.*;
import java.util.*;

public class Main {
    static int N = 0;
    static int R = 0;
    static int[][] map;
    static int minGap = Integer.MAX_VALUE;
    static long targetCombiCnt = 0;
    static int combiCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = N / 2;

        map = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        targetCombiCnt = (factorial(R + 1, N) / factorial(2, R)) / 2;

        combination(1, 1, N / 2, new ArrayList<Integer> (R));

    }

    static void combination(int pickNum, int pickCnt, int maxPick, ArrayList<Integer> picks) {
        if(combiCnt > targetCombiCnt) {
            System.out.println(minGap);
            System.exit(0);
        }

        if(pickCnt > maxPick) {
            int gap = getGap(picks);
            if(gap < minGap) minGap = gap;
            combiCnt++;
            return;
        }

        for(int i = pickNum; i <= N; i++) {
            ArrayList<Integer> copyPicks = new ArrayList<>(picks);
            copyPicks.add(i);
            combination(i + 1, pickCnt + 1, maxPick, copyPicks);
        }
    }

    static int getGap(ArrayList<Integer> picks) {
        ArrayList<Integer> unPicks = new ArrayList<>();
        boolean[] isPick = new boolean[N + 1];

        for(int pickNum : picks) {
            isPick[pickNum] = true;
        }

        for(int i = 1; i <= N; i++) {
            if(!isPick[i]) unPicks.add(i);
        }

        long team1Sum = 0;
        long team2Sum = 0;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < R; j++) {
                team1Sum += map[picks.get(i)][picks.get(j)];
                team2Sum += map[unPicks.get(i)][unPicks.get(j)];
            }
        }

        return (int) Math.abs(team1Sum - team2Sum);
    }

    static long factorial(int start, int end) {
        long num = 1;
        for(int i = start; i <= end; i++) {
            num *= i;
        }
        return num;
    }
}
