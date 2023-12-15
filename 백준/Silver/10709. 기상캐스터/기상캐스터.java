// width: w(1 <= w <= 100), j
// height: h(1 <= h <= 100), i
// 서 -> 동

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        for(int i = 0; i < h; i++) {
            String input = br.readLine();

            boolean isFindCloud = false;
            int minute = -1;

            for(int j = 0; j < input.length(); j++) {
                if(input.charAt(j) == 'c') {
                    minute = 0;
                    isFindCloud = true;
                } else {
                    if(isFindCloud) minute++; 
                }

                sb.append(minute).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}