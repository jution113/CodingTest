import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] map = new boolean[101][101];
    static int[] dirY = {0, -1, 0, 1};
    static int[] dirX = {1, 0, -1, 0};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Integer> dirList = makeDragonCurve(d, g);
            paintDragonCurve(dirList, y, x);
        }

        countDragonCurve();
        System.out.println(cnt);
    }

    public static List<Integer> makeDragonCurve(int d, int g) {
        List<Integer> dirList = new ArrayList<> ();
        dirList.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = dirList.size() - 1; j >= 0; j--)
                dirList.add((dirList.get(j) + 1) % 4);
        }
        return (dirList);
    }

    public static void paintDragonCurve(List<Integer> dirList, int y, int x) {
        map[y][x] = true;

        for (int dir : dirList) {
            y += dirY[dir];
            x += dirX[dir];
            map[y][x] = true;
        }
    }

    public static void countDragonCurve() {
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                if (map[y][x] && map[y][x + 1] && map[y + 1][x] && map[y + 1][x + 1])
                    cnt++;
            }
        }
    }
}