import java.util.*;
import java.io.*;

public class Main {
    static int oneChunkCnt = 0;
    static int zeroChunkCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int cur = 0;
        int prev = 0;
        int res = 0;

        for (int i = 0; i < input.length(); i++) {
            cur = input.charAt(i) - '0';
            if (i == 0) {
                countChunk(cur);
            } else if(cur != prev) {
                countChunk(cur);
            }
            prev = cur;
        }
        res = Math.min(zeroChunkCnt, oneChunkCnt);
        System.out.print(res);
    }

    public static void countChunk(int num) {
        if (num == 0) {
            zeroChunkCnt++;
        } else {
            oneChunkCnt++;
        }
    }
}
