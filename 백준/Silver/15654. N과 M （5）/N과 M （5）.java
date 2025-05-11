import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> peeks = new ArrayList<> ();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutation(0);
        System.out.print(sb);
    }

    static void permutation(int peekCnt) {
        if (peekCnt == M) {
            makeRes();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            peeks.add(arr[i]);
            permutation(peekCnt + 1);
            visited[i] = false;
            peeks.remove(peeks.size() - 1);
        }
    }

    static void makeRes() {
        for (Integer num : peeks) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
    }
}
