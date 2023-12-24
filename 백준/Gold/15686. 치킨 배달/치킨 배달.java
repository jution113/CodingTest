import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static ArrayList<Position> homes = new ArrayList<>();
    static ArrayList<Position> stores = new ArrayList<>();
    static boolean[] selected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());

                if(input == 1) {
                    homes.add(new Position(i, j));
                } else if(input == 2) {
                    stores.add(new Position(i, j));
                }

                map[i][j] = input;
            }
        }

        
        selected = new boolean[stores.size()];

        select(0, 0, m);

        System.out.println(min);
    }

    static class Position {
        int col;
        int row;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static void select(int start, int peekCnt, int targetCnt) {
        if(peekCnt == targetCnt) {
            int totalDistance = 0;
            
            for(Position home : homes) {
                totalDistance += getMinDistance(home);
            }

            if(min > totalDistance) min = totalDistance;
            return;
        }

        for(int i = start; i < stores.size(); i++) {
            selected[i] = true;
            select(i + 1, peekCnt + 1, targetCnt);
            selected[i] = false;
        }
    }

    static int getMinDistance(Position home) {
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < selected.length; i++) {
            if(selected[i]) {
                Position store = stores.get(i);
                int distance = Math.abs(store.row - home.row) + Math.abs(store.col - home.col);
                if(distance < min) min = distance;
            }
        }

        return min;
    }
}