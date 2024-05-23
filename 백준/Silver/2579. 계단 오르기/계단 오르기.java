import java.util.*;
import java.io.*;

public class Main {
    static int stairCnt;
    static int[] stairs;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stairCnt = Integer.parseInt(br.readLine());
        stairs = new int[stairCnt + 1];
        scores = new int[stairCnt + 1];

        for(int i = 1; i <= stairCnt; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        scores[1] = stairs[1];
        if(stairCnt >= 2) scores[2] = stairs[1] + stairs[2];
        if(stairCnt >= 3) scores[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
        if(stairCnt >= 4) {
            for(int i = 4; i <= stairCnt; i++) {
                scores[i] = Math.max(scores[i -  3] + stairs[i - 1], scores[i - 2]) + stairs[i];
            }
        }

        System.out.println(scores[stairCnt]);
    }
}