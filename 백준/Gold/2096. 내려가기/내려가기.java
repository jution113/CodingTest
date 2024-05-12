import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] maxArrTmp = new int[3];
        int[] minArrTmp = new int[3];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] maxArr = new int[3];
            int[] minArr = new int[3];

            for(int j = 0; j < 3; j++) {
                int input = Integer.parseInt(st.nextToken());

                if(i == 0) {
                    maxArr[j] = input;
                    minArr[j] = input;
                    continue;
                }

                if(j == 0) {
                    maxArr[j] = Math.max(maxArrTmp[j] + input, maxArrTmp[j + 1] + input);
                    minArr[j] = Math.min(minArrTmp[j] + input, minArrTmp[j + 1] + input);
                } else if(j == 2) {
                    maxArr[j] = Math.max(maxArrTmp[j - 1] + input, maxArrTmp[j] + input);
                    minArr[j] = Math.min(minArrTmp[j - 1] + input, minArrTmp[j] + input);
                } else {
                    maxArr[j] = Math.max(maxArrTmp[j] + input, maxArrTmp[j + 1] + input);
                    minArr[j] = Math.min(minArrTmp[j] + input, minArrTmp[j + 1] + input);

                    maxArr[j] = Math.max(maxArr[j], maxArrTmp[j - 1] + input);
                    minArr[j] = Math.min(minArr[j], minArrTmp[j - 1] + input);
                }
            }

            maxArrTmp = maxArr;
            minArrTmp = minArr;
        }

        for(int i = 0; i < 3; i++) {
            max = Math.max(maxArrTmp[i], max);
            min = Math.min(minArrTmp[i], min);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max);
        sb.append(" ");
        sb.append(min);
        System.out.println(sb);
    }
}
