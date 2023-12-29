import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static String[] compare;
    static int[] src1;
    static int[] src2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(br.readLine());
        src1 = new int[k + 1];
        src2 = new int[k + 1];
        compare = new String[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) compare[i] = st.nextToken();

        for(int i = 0; i < k + 1; i++) {
            src1[i] = 9 - i;
            src2[i] = i;
        }

        order(src1);
        order(src2);

        for(int num : src1) sb.append(num);
        sb.append('\n');
        for(int num : src2) sb.append(num);
        
        System.out.print(sb);
    }
    
    static void order(int[] src) {
        boolean isOrdered = false;

        while(!isOrdered) {
            isOrdered = true;

            for(int i = 0; i < k; i++) {
                switch(compare[i]) {
                    case ">":
                        if(src[i] < src[i + 1]) {
                            swap(src, i, i + 1);
                            isOrdered = false;
                        }
                        break;
                    case "<":
                        if(src[i] > src[i + 1]) {
                            swap(src, i, i + 1);
                            isOrdered = false;
                        }
                        break;
                }
            }
        }
    }

    static void swap(int[] src, int a, int b) {
        int tmp = src[a];
        src[a] = src[b];
        src[b] = tmp;
    }
    
}