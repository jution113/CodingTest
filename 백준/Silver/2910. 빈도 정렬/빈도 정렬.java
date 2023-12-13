import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 순서 있게 등장한 수외 등장 빈도를 저장할 map
        // idx <value, count>
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<> ();
        
        // 순서 있게 등장한 빈도와 해당 빈도로 등장한 수들의 배열
        // idx <count, values1, values2...>
        LinkedHashMap<Integer, ArrayList<Integer>> modifiedMap = new LinkedHashMap<> ();

        // 등장 빈도를 저장할 set
        Set<Integer> set = new HashSet<> ();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());

            if(map.get(input) == null) {
                map.put(input, 1);
            } else {
                map.put(input, map.get(input) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            set.add(count);

            if(modifiedMap.get(count) == null) {
                ArrayList<Integer> values = new ArrayList<Integer> ();
                values.add(value);
                modifiedMap.put(count, values);
            } else {
                ArrayList<Integer> values = modifiedMap.get(count);
                values.add(value);
                modifiedMap.put(count, values);
            }

        }

        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr, Collections.reverseOrder());

        for(int count : arr) {
            ArrayList<Integer> values = modifiedMap.get(count);

            for(int value : values) {
                for(int i = 0; i < count; i++) {
                    sb.append(value).append(' ');
                }
            }
        }


        System.out.print(sb);
    }

}