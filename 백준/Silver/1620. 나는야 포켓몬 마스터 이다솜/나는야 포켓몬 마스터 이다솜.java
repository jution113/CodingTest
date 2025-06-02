import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map1 =  new HashMap<> ();
        Map<String, String> map2 =  new HashMap<> ();
        StringBuilder sb = new StringBuilder();

        for (int num = 1; num <= N; num++) {
            String name = br.readLine();
            String strNum = String.valueOf(num);
            map1.put(strNum, name);
            map2.put(name, strNum);
        }
        for (int m = 0; m < M; m++) {
            String key = br.readLine();
            if (map1.containsKey(key)) {
                sb.append(map1.get(key)).append("\n");
            } else {
                sb.append(map2.get(key)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
