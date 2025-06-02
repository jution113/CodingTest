import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<> ();
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("all")) {
                set.clear();
                for (int i = 1; i <= 20; i++) set.add(i);
            } else if (command.equals("empty")) {
                set.clear();
            } else {
                int num = Integer.parseInt(st.nextToken());
                switch(command) {
                    case "add":
                        set.add(num);
                        break;
                    case "remove":
                        set.remove(num);
                        break;
                    case "check":
                        String res = set.contains(num) ? "1" : "0";
                        sb.append(res).append("\n");
                        break;
                    case "toggle":
                        if (set.contains(num)) {
                            set.remove(num);
                        } else {
                            set.add(num);
                        }
                        break;
                }
            }
        }
        System.out.print(sb);
    }
}
