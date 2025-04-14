import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> cardCntMap = new HashMap<>();
        int N =  Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            cardCntMap.put(num, cardCntMap.getOrDefault(num, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int M =  Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(cardCntMap.getOrDefault(num, 0)).append(" ");
        }

        System.out.print(sb);
    }
}