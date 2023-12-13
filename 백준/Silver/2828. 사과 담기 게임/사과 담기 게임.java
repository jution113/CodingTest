import java.util.*;
import java.io.*;

public class Main {
    static final int IDX_OFFSET = 1;
    static int m;
    static int[] screen;
    static int start;
    static int end;
    static int result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int j = Integer.parseInt(br.readLine());

        screen = new int[IDX_OFFSET + n];
        start = IDX_OFFSET;
        end = IDX_OFFSET + m - 1;
        result = 0;

        for(int i = 0; i < j; i++) { 
            int input = Integer.parseInt(br.readLine());
            move(input);
        }

        System.out.print(result);

    }

    static void move(int target) {
        if(target < start) {
            result += start - target;
            start = target;
            end = target + m - 1;
        } else if(end < target) {
            result += target - end;
            end = target;
            start = end - m + 1;
        }
    }
}