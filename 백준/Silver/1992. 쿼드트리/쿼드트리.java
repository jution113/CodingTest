import java.util.*;
import java.io.*;

public class Main {
    static int[][] src;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        src = new int[n][n];

        for(int i = 0; i < n; i ++) {
            String inputLine = br.readLine();
            for(int j = 0; j < n; j++) {
                int input = Character.getNumericValue(inputLine.charAt(j));
                src[i][j] = input;
            }
        }

        compress(0, 0, n, n);

        System.out.println(sb);

    }

    static boolean isCompressible(int startX, int startY, int endX, int endY) {
        for(int x = startX; x < endX; x++) {
            for(int y = startY; y < endY; y++) {
                if(src[x][y] != src[startX][startY]) return false;
            }
        }
        return true;
    }

    static void compress(int startX, int startY, int endX, int endY) {
        if(isCompressible(startX, startY, endX, endY)) {
            sb.append(src[startX][startY]);
            return;
        }

        sb.append('(');

        int centerX = (startX + endX) / 2;
        int centerY = (startY + endY) / 2;

        compress(startX, startY, centerX, centerY);
        compress(startX, centerY, centerX, endY);
        compress(centerX, startY, endX, centerY);
        compress(centerX, centerY, endX, endY);

        sb.append(')');
    }
}